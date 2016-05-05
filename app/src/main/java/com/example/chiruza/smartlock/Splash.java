package com.example.chiruza.smartlock;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {

    public static final int segundos = 4;
    public static final int milisegundos = segundos*1000;
    public static final int delay = 2;
    private ProgressBar pBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pBar = (ProgressBar) findViewById(R.id.pBar);
        pBar.setMax(maximoProgreso());
        empezaranimacion();
    }

    public void empezaranimacion(){
        new CountDownTimer(milisegundos,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                pBar.setProgress(establecerProgreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevoform = new Intent(Splash.this,Login.class);
                startActivity(nuevoform);
                finish();
            }
        }.start();
    }

    public int establecerProgreso(long miliseconds){
        return (int)((milisegundos-miliseconds)/1000);
    }

    public int maximoProgreso(){
        return segundos - delay;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
