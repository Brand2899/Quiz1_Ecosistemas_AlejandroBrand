package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewRegister extends AppCompatActivity {

    private TextView txtHead1;
    private TextView txtTitle1;
    private  TextView txtSubTitle1;

    private ConstraintLayout container_big1;

    private EditText editTxtName;
    private EditText editTxtCode;

    private Button bnContinue1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);
    }
}