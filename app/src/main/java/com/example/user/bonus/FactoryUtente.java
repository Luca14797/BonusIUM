package com.example.user.bonus;

import java.util.ArrayList;
import java.util.List;

public class FactoryUtente {
    private static FactoryUtente instance;
    private List<Utente> utenti = new ArrayList<>();

    private FactoryUtente () {
        this.utenti.add(new Utente("Luca","Ciao"));
        this.utenti.add(new Utente("Nicola","Miao"));
        this.utenti.add(new Utente("Elena","Piano"));
    }

    public static FactoryUtente getInstance () {
        if (instance == null) {
            instance = new FactoryUtente();
        }
        return instance;
    }

    /**
     * Il metodo controlla che il Nome Utente e la Password siano corretti
     * @return Restituisce True se Nome Utente e Password sono corretti, False altrimenti
     */
    public boolean login(Utente utente) {
        for (Utente aux : this.utenti) {
            if (aux.getNomeUtente().equals(utente.getNomeUtente()) && aux.getPassword().equals(utente.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
