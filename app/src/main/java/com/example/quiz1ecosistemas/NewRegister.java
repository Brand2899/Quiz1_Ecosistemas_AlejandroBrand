package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        txtHead1 = findViewById(R.id.txtHead1);
        txtTitle1 = findViewById(R.id.txtTitle3);
        txtSubTitle1 = findViewById(R.id.txtSubTitle3);

        container_big1 = findViewById(R.id.container_big2);

        editTxtName = findViewById(R.id.editTxtName);
        editTxtCode = findViewById(R.id.editTxtCode);

        bnContinue1 = findViewById(R.id.bnEnd);

        bnContinue1.setOnClickListener(
                (v) -> {
                    if(editTxtName.getText().toString().isEmpty() || editTxtCode.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
                    } else{
                    }
                }
        );
    }
}