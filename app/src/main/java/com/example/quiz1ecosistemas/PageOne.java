package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PageOne extends AppCompatActivity {

    private TextView txtHead2;
    private TextView txtTitle1;
    private TextView txtSubTitle1;

    private ConstraintLayout container_big2;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private Button bnContinue1;

    private int score;

    private String name;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_one);

        txtHead2 = findViewById(R.id.txtHead2);
        txtTitle1 = findViewById(R.id.txtTitle1);
        txtSubTitle1 = findViewById(R.id.txtSubTitle1);

        container_big2 = findViewById(R.id.container_big2);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        bnContinue1 = findViewById(R.id.bnContinue1);
        blockButton();

        name = getIntent().getExtras().getString("name");
        code = getIntent().getExtras().getString("code");

        score = 0;

        bnContinue1.setOnClickListener(
                (v) -> {
                    calcScore();
                    Intent i = new Intent(this, PageTwo.class);
                    i.putExtra("name", name);
                    i.putExtra("code", code);
                    i.putExtra("score", score);
                    startActivity(i);
                }
        );

    }

    public void blockButton(){
        bnContinue1.setEnabled(false);

        new Thread(
                () -> {
                    while(true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()){
                            runOnUiThread(
                                    () ->{
                                        bnContinue1.setEnabled(true);

                                    }
                            );
                        }
                    }
                }
        ).start();
    }

    public void calcScore(){
        if(checkBox1.isChecked()){
            score += 1;
        }
        if(checkBox2.isChecked()){
            score += 3;
        }
        if(checkBox3.isChecked()){
            score += 0;
        }
    }
}