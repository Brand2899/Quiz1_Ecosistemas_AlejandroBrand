package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtHead;
    private TextView txtTitle;

    private ConstraintLayout container_big;
    private ConstraintLayout container_text;

    private Button bnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHead = findViewById(R.id.txtHead);
        txtTitle = findViewById(R.id.txtTitle3);

        container_big = findViewById(R.id.container_big);
        container_text = findViewById(R.id.container_text);

        bnRegister = findViewById(R.id.bnEnd);

        bnRegister.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, NewRegister.class);
                    startActivity(i);
                }
        );

    }
}