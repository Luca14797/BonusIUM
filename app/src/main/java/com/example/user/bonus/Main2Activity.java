package com.example.user.bonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {

    Utente utente;
    Utente[] utenti = {new Utente("Luca","Ciao"), new Utente("Nicola","Miao")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.OK_LOGIN);

        if (obj instanceof Utente) {
            utente = (Utente) obj;
        } else {
            utente = new Utente();
        }
    }

    private boolean login() {
        for (int i=0; i<utenti.length; i++) {
            if (utenti[i].getNomeUtente().equals(utente.getNomeUtente()) && utenti[i].getPassword().equals(utente.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
