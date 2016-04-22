package com.example.alejandro.smatlock;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button btni, btno, btnr;
    EditText etu, etc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etu = (EditText) findViewById(R.id.etu);
        etc = (EditText) findViewById(R.id.etc);
        btni = (Button) findViewById(R.id.btningresar);
        btno = (Button) findViewById(R.id.btnolvide);
        btnr = (Button) findViewById(R.id.btnguest);
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.etu)).getText().toString();
                String pass = ((EditText)findViewById(R.id.etc)).getText().toString();
                String url = "http://smartlock.tunesources.com/php/login.php";
                PostResponseAsyncTask task1 = new PostResponseAsyncTask(Login.this, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {

                        Toast.makeText(Login.this, s, Toast.LENGTH_LONG).show();

                    }
                });
                task1.execute(url);
                    if()

                    {
                        Intent nuevoform = new Intent(Login.this, Principal.class);
                        startActivity(nuevoform);
                        finish();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;

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
    /*
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                    String etuus = etu.getText().toString();
                    String etcus = etc.getText().toString();

                    Usuario usuario = new Usuario(etuus, etcus);
                    Authenticate(usuario);

                    UserLocalStore.storeUserData(usuario);
                    UserLocalStore.setUserLoggedIn(true);

                    break;
            }
        }
    */


    private void showErrorMessage(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
        dialogBuilder.setMessage("Datos de usuario incorrectos");
        dialogBuilder.setPositiveButton("OK",null);
        dialogBuilder.show();
    }



    @Override
    public void onClick(View v) {

    }
}
