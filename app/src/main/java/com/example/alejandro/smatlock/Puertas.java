package com.example.alejandro.smatlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Puertas extends AppCompatActivity {
    private Button btng;
    private TextView tvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puertas);
        btng = (Button) findViewById(R.id.btng);
        tvc = (TextView) findViewById(R.id.tvc);
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
