package com.example.dentista.dentista;

import java.util.Date;

public class Paziente {
    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private String patologia;

    private int dataRegistrazione;

    public Paziente(String nome, String cognome, int eta, String codiceFiscale, String patologia, int dataRegistrazione){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.patologia = patologia;
        this.dataRegistrazione = dataRegistrazione;
    }

    public int getDataRegistrazione() {
        return dataRegistrazione;
    }

    @Override
    public String toString() {
        return nome + "," + cognome + "," + eta + "," + codiceFiscale + "," + patologia + "," + dataRegistrazione;
    }
}
