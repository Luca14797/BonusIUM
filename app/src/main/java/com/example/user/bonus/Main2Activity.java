package com.example.user.bonus;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {

    Utente utente;
    TextView testoLogin;
    Button indietro;
    FactoryUtente factory = FactoryUtente.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Dalla prima Activity vengono recuperati i dati dell'utente
        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.OK_LOGIN);

        if (obj instanceof Utente) {
            utente = (Utente) obj;
        } else {
            utente = new Utente();
        }

        testoLogin = (TextView) findViewById(R.id.textViewResult);
        indietro = (Button) findViewById(R.id.indietro);

        ColorStateList defaultColor = testoLogin.getTextColors();

        if (factory.login(utente)) {      // Si controlla se i dati dell'utente sono corretti
            testoLogin.setTextColor(defaultColor);
            testoLogin.setText("Benvenuto" + " " + utente.getNomeUtente());
        } else {
            testoLogin.setTextColor(Color.RED);
            testoLogin.setText("Accesso Negato");
        }

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent showResults = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(showResults);
            }
        });
    }
}
