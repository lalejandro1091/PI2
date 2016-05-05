package com.example.chiruza.smartlock;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.MainActivity;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.ObjectOutputStream;

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
                String url3 = "http://smartlock.tunesources.com/php/totp.php";
                PostResponseAsyncTask task3 = new PostResponseAsyncTask(Puertas.this, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        tvc.setText(s);
                        //Toast.makeText(Puertas.this, s, Toast.LENGTH_LONG).show();

                    }
                });
                task3.execute(url3);
    }
});
    }
}