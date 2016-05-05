package com.example.chiruza.smartlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class Registrarse extends AppCompatActivity implements View.OnClickListener{

    EditText nombreui, apellido1, apellido2, usuarioi, contrasena1, contrasena2, descripcioni;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombreui = (EditText) findViewById(R.id.etnamei);
        if( nombreui.getText().toString().length() == 0 )
            nombreui.setError( "Ingresa el nombre" );
        apellido1 = (EditText) findViewById(R.id.etlastname1);
        if( apellido1.getText().toString().length() == 0 )
            apellido1.setError( "Ingresa el primer apellido" );
        apellido2 = (EditText) findViewById(R.id.etlastname2);
        if( apellido2.getText().toString().length() == 0 )
            apellido2.setError( "Ingresa el segundo apellido" );
        usuarioi = (EditText) findViewById(R.id.etuseri);
        if( usuarioi.getText().toString().length() == 0 )
            usuarioi.setError( "Ingresa un nombre de usuario" );
        contrasena1 = (EditText) findViewById(R.id.etpass1);
        if( contrasena1.getText().toString().length() == 0 )
            contrasena1.setError( "Ingresa la contraseña" );
        contrasena2 = (EditText) findViewById(R.id.etpass2);
        if( contrasena2.getText().toString().length() == 0 ) {
            contrasena2.setError("Ingresa la segunda contraseña");
        }if(contrasena1.getText().toString() != contrasena2.getText().toString()){
            contrasena2.setError("Las contraseñas no coinciden");
        }
        descripcioni = (EditText) findViewById(R.id.etdescripcion);
        if( descripcioni.getText().toString().length() == 0 )
            descripcioni.setError( "Ingresa la descripcion" );
        bRegister = (Button) findViewById(R.id.btnregistrar);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        String nnombreui = nombreui.getText().toString();
        String aapellido1 = apellido1.getText().toString();
        String aapellido2 = apellido2.getText().toString();
        String uusuarioi = usuarioi.getText().toString();
        String ccontrasena1 = contrasena1.getText().toString();
        String ddescripcioni = descripcioni.getText().toString();
        String url1 = "http://smartlock.tunesources.com/php/register.php";
        postData.put("nombreui", nnombreui);
        postData.put("apellido1", aapellido1);
        postData.put("apellido2", aapellido2);
        postData.put("usuarioi", uusuarioi);
        postData.put("contrasena1", ccontrasena1);
        postData.put("descripcion", ddescripcioni);

        PostResponseAsyncTask task2 = new PostResponseAsyncTask(Registrarse.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if (s.contains("1")){
                    Intent nuevoform = new Intent(Registrarse.this, Login.class);
                    startActivity(nuevoform);
                    finish();
                }
            }
        });
        task2.execute(url1);
    }
}
