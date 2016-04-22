package com.example.alejandro.smatlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrarse extends AppCompatActivity implements View.OnClickListener{
    EditText nombreu, apellidoa, usuarioa, contrasena, descripciona;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombreu = (EditText) findViewById(R.id.editText);
        apellidoa = (EditText) findViewById(R.id.editText2);
        usuarioa = (EditText) findViewById(R.id.editText3);
        contrasena = (EditText) findViewById(R.id.editText4);
        descripciona = (EditText) findViewById(R.id.editText5);
        bRegister = (Button) findViewById(R.id.btnregistrar);

        bRegister.setOnClickListener(this);
    }

    public void onClick(View paramView){

    }


}
