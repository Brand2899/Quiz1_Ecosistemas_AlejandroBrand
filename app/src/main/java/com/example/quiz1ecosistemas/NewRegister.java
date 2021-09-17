package com.example.quiz1ecosistemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewRegister extends AppCompatActivity {

    private TextView txtHead;
    private TextView txtTitle;
    private  TextView txtSubTitle;

    private ConstraintLayout container_big1;

    private EditText editTxtName;
    private EditText editTxtCode;

    private Button bnContinue;

    private String name;
    private String code;

    private boolean passCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        txtHead = findViewById(R.id.txtHead);
        txtTitle = findViewById(R.id.txtTitle);
        txtSubTitle = findViewById(R.id.txtSubTitle);

        container_big1 = findViewById(R.id.container_big1);

        editTxtName = findViewById(R.id.editTxtName);
        editTxtCode = findViewById(R.id.editTxtCode);

        bnContinue = findViewById(R.id.bnContinue);

        passCode = false;

        bnContinue.setOnClickListener(
                (v) -> {

                    if(editTxtName.getText().toString().isEmpty() || editTxtCode.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
                    } else{

                        name = editTxtName.getText().toString().replace(" ", "");
                        code = editTxtCode.getText().toString().replace(" ", "");

                        checkRegisteredCode();

                        if(passCode){
                            Intent i = new Intent(this, PageOne.class);
                            i.putExtra("name", name);
                            i.putExtra("code", code);
                            startActivity(i);
                            finish();
                        }else {
                            Toast.makeText(this, "Código ya registrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void checkRegisteredCode(){
        String[] codeList = getSharedPreferences("listCodes", MODE_PRIVATE).getString("list", "").split(";");
        if(codeList.length == 0){
            passCode = true;
        }else{
            for(int i = 0; i < codeList.length; i++){
                if(!(codeList[i].equalsIgnoreCase(code))){
                    passCode = true;
                }else{
                    passCode = false;
                }
            }
        }
    }
}