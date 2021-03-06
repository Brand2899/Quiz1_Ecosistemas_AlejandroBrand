package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PageTwo extends AppCompatActivity {

    private TextView txtHead3;
    private TextView txtTitle2;
    private TextView txtSubTitle2;

    private ConstraintLayout container_big3;

    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;

    private Button bnEnd;

    private String name;
    private String code;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        txtHead3 = findViewById(R.id.txtHead3);
        txtTitle2 = findViewById(R.id.txtTitle2);
        txtSubTitle2 = findViewById(R.id.txtSubTitle2);

        container_big3 = findViewById(R.id.container_big3);

        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);

        bnEnd = findViewById(R.id.bnEnd);

        name = getIntent().getExtras().getString("name");
        code = getIntent().getExtras().getString("code");
        score = getIntent().getExtras().getInt("score");

        blockButton();

        bnEnd.setOnClickListener(
                (v) -> {
                    calcScore();

                    Intent i = new Intent(this, MainActivity.class);
                    i.putExtra("name", name);
                    i.putExtra("code", code);
                    i.putExtra("score", score);
                    saveUser();
                    saveCodeList();
                    startActivity(i);
                    finish();
                }
        );
    }

    public void blockButton(){
        bnEnd.setEnabled(false);

        new Thread(
                () -> {
                    while(true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()){
                            runOnUiThread(
                                    () ->{
                                        bnEnd.setEnabled(true);
                                    }
                            );
                        }
                    }
                }
        ).start();
    }

    public void calcScore(){
        if(checkBox4.isChecked()){
            score += 3;
        }
        if(checkBox5.isChecked()){
            score += 3;
        }
        if(checkBox6.isChecked()){
            score += 0;
        }
    }

    public void saveUser(){
        SharedPreferences preferences = getSharedPreferences("savedUser", MODE_PRIVATE);
        String user = "Nombre: " + name + "\n"+"C??digo: " + code + "\n" + "Puntaje: " + score + "\n" + "\n";
        String lastUser = preferences.getString("print", "");
        preferences.edit().putString("print", lastUser + user).apply();
    }

    public void saveCodeList(){
        SharedPreferences listCodes = getSharedPreferences("listCodes", MODE_PRIVATE);
        String newCode = code + ";";
        String oldCodes = listCodes.getString("list", "");
        listCodes.edit().putString("list", oldCodes + newCode).apply();
    }
}