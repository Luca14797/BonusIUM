package com.example.user.bonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button accedi;
    Utente utente;

    public static final String OK_LOGIN = "com.example.user.bonus.Utente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        accedi = (Button) findViewById(R.id.accedi);

        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {     // Si controlla se l'utente ha compilato tutti i campi
                    utente = new Utente(username.getText().toString(), password.getText().toString());
                    Intent showResults = new Intent(MainActivity.this, Main2Activity.class);
                    showResults.putExtra(OK_LOGIN, utente);
                    startActivity(showResults);
                }
            }
        });
    }

    /**
     * Il metodo controlla se l'utente ha inserito il Nome Utente e la Password
     * @return Restituisce True se l'utente ha compilato tutti i campi, False altrimenti
     */
    private boolean checkInput() {
        int errors = 0;

        if (username.getText() == null || username.getText().length() == 0) {
            username.setError("Nome utente non inserito");
            errors++;
        } else {
            username.setError(null);
        }

        if (password.getText() == null || password.getText().length() == 0) {
            password.setError("Password non inserita");
            errors++;
        } else {
            password.setError(null);
        }

        return errors == 0;
    }
}
