package com.example.user.bonus;

import java.io.Serializable;

public class Utente implements Serializable {
    private String nomeUtente;
    private String password;

    public Utente (String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
    }

    public Utente () {
        this.nomeUtente = "";
        this.password = "";
    }

    public String getNomeUtente () {
        return this.nomeUtente;
    }

    public String getPassword () {
        return this.password;
    }

    public void setNomeUtente (String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}
