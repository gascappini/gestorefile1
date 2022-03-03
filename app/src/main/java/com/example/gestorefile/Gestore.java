package com.example.gestorefile;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;


/**
 * @author Studente
 * @see //librerie, versioni, manuale tecnico...
 */


public class Gestore {
    String nomeFile;
    Context c;
    StringBuilder sb;



    //COSTRUTTORE
    public Gestore(String nomeFile, Context c) {
        this.nomeFile = nomeFile;
        this.c = c;
        sb = new StringBuilder();
    }


    /**
     *
     * @param nomeFile   nome del file che verrà visualizzato
     * @param c          contesto
     * @return
     */


    //METODO LETTURA FILE
    public String leggiFile(String nomeFile, Context c){
        String str = "";

        try {
        //SERVE PER LEGGERE       c = è il contesto
            //APERTURA DEL FILE
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
        //CICLO PER LEGGERE RIGA PER RIGA
            // ACCODO OGNI RIGA ALLA STRINGA
            String inputString;
        while ((inputString = inputReader.readLine())!=null){
            sb.append(inputString + "\n");
        }

        } catch (FileNotFoundException e){
            Log.e(TAG, "ERRORE FILE NON TROVATO");
            return "FNF";
            } catch (IOException e) {
            Log.e(TAG, "ERRORE IN LETTURA");
            return "IO ERROR";
            }

        return sb.toString();
    }



    public String scriviFile(String nomeFile, Context c ){

        FileOutputStream fileO;
        String esito = "";


        String testodascrivere = "Questo è il testo del file";

        try {
            fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            fileO.write(testodascrivere.getBytes());
        }

        catch (FileNotFoundException e) {
            esito = "Attenzione errore in apertura";
        }

        catch (IOException e){
            esito = "errore in scrittura";
        }

        return esito;
    }



    public String leggiFileRaw(Context c){
        String testo = "";

        StringBuilder sb = new StringBuilder();

        //attraverso il contesto prendo tutte le risorse, file compresi
        Resources res = c.getResources();
        InputStream is = res.openRawResource(R.raw.brani);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try{

        while ((testo = br.readLine())!= null){
            sb.append(testo + "\n");
        }

        }catch (IOException e){
            e.printStackTrace();
        }

        return sb.toString();
    }


    //cartella drawable, conterrà immagini con la corretta definizione in base al tipo di dispositivo
    //cartella layout, conterrà tutti gli xml
    //cartella values, contiene altri file xml in particolare il file strings.xml, color.xml
    //cartella values per creare stringhe particolari
    //



    public String leggiAssets(){
        AssetManager am = c.getAssets();
        try {
            am.open("lyrics.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



}
