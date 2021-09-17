package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtHead;
    private TextView txtTitle;
    private TextView txtPrint;

    private ConstraintLayout container_big;
    private ConstraintLayout container_text;

    private Button bnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHead = findViewById(R.id.txtHead);
        txtTitle = findViewById(R.id.txtTitle);
        txtPrint = findViewById(R.id.txtPrint);

        container_big = findViewById(R.id.container_big);
        container_text = findViewById(R.id.container_text);

        bnRegister = findViewById(R.id.bnContinue);

        bnRegister.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, NewRegister.class);
                    startActivity(i);
                    finish();
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
        Print();
    }

    public void Print(){
        String print = getSharedPreferences("savedUser", MODE_PRIVATE).getString("print", "no usuario");
        txtPrint.setText("hola");
        Toast.makeText(this, print, Toast.LENGTH_SHORT).show();
    }
}