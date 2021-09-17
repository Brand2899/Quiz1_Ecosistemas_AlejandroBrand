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

    private ArrayList<String> registeredNames;
    private ArrayList<String> registeredCodes;

    private boolean passedName;
    private boolean passedCode;

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

        registeredNames = new ArrayList<String>();
        registeredCodes = new ArrayList<String>();

        passedName = false;
        passedCode = false;

        bnContinue.setOnClickListener(
                (v) -> {

                    if(editTxtName.getText().toString().isEmpty() || editTxtCode.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
                    } else{

                        name = editTxtName.getText().toString();
                        code = editTxtCode.getText().toString();

                        checkRegisteredName();
                        checkRegisteredCode();

                        if(passedName && passedCode){
                            registeredNames.add(name);
                            registeredCodes.add(code);

                           // Toast.makeText(this, "" + passedName, Toast.LENGTH_SHORT).show();
                          //  Toast.makeText(this, "" + passedCode, Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(this, PageOne.class);
                            i.putExtra("name", name);
                            i.putExtra("code", code);
                            startActivity(i);
                        }else{
                            Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void checkRegisteredName(){
        if(registeredNames.size() == 0){
            passedName = true;
        }else{
            for(int i = 0; i < registeredNames.size(); i++){
                if(!(registeredNames.get(i) == name)){
                    passedName = true;
                }
            }
        }
    }

    public void checkRegisteredCode(){
        if(registeredCodes.size() == 0){
            passedCode = true;
        }else{
            for(int i = 0; i < registeredCodes.size(); i++){
                if(!(registeredCodes.get(i) == code)){
                    passedCode = true;
                }
            }
        }
    }
}