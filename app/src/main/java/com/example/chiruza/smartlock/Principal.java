package com.example.chiruza.smartlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button btnpu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnpu = (Button) findViewById(R.id.btnp);



        btnpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform = new Intent(Principal.this, Puertas.class);
                startActivity(nuevoform);
                finish();
            }
        });
    }
}
