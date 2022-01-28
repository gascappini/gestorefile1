package com.example.gestorefile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gestore {
    String nomeFile;

    Context c;


    //COSTRUTTORE


    public Gestore(String nomeFile, Context c) {
        this.nomeFile = nomeFile;
        this.c = c;
    }

    public String leggiFile(String nomeFile){
        String str = "";

        try {

        //SERVE PER LEGGERE       c = è il contesto
        BufferedReader br = BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));

        str = br.readLine();

        } catch (FileNotFoundException e){
            Log.e("Errore", "Errore nel messaggio");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return str;
    }


    public void scriviFile(String nomeFile, String testo){

    }



}
