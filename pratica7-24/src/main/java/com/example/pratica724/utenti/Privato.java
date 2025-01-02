package com.example.pratica724.utenti;

import com.example.pratica724.auto.*;

import java.util.ArrayList;

public class Privato extends Utente{
    private String nomeCognome,codiceFiscale,numeroCie;
    private Auto autoAttuale;
    private ArrayList<Auto> autoPreferite;

    //Costruttore
    public Privato(String nomeUtente, String locazione, String email, String telefono, String nomeCognome, String numeroCie, Auto autoAttuale,String codiceFiscale) {
        super(nomeUtente, locazione, email, telefono);
        setNomeCognome(nomeCognome);
        setNumeroCie(numeroCie);
        setCodiceFiscale(codiceFiscale);
        this.autoAttuale = autoAttuale;
        this.autoPreferite=new ArrayList<Auto>();
    }

    //get e set
    public String getNomeCognome() { return nomeCognome; }
    public void setNomeCognome(String nomeCognome) {
        if (isValidNomeCognome(nomeCognome))
            this.nomeCognome = nomeCognome;
        else
            this.nomeCognome = null;
    }
    public String getCodiceFiscale() { return codiceFiscale; }
    public void setCodiceFiscale(String codiceFiscale) {
        if (isValidCodiceFiscale(codiceFiscale))
            this.codiceFiscale = codiceFiscale;
        else
            this.codiceFiscale = null;
    }
    public String getNumeroCie() { return numeroCie; }
    public void setNumeroCie(String numeroCie) {
        if (isValidCIE(numeroCie))
            this.numeroCie = numeroCie;
        else
            this.numeroCie = null;
    }
    public Auto getAutoAttuale() { return autoAttuale; }
    public void setAutoAttuale(Auto autoAttuale) { this.autoAttuale = autoAttuale; }
    public ArrayList<Auto> getAutoPreferite() { return autoPreferite; }

    //metodi
    public void aggiungiAutoPreferite(Auto auto){ this.autoPreferite.add(auto); }
    public void rimuoviAutoPreferite(Auto auto){ this.autoPreferite.remove(auto); }
    @Override
    public String toString(){ return "Privato: "+this.nomeCognome+super.toString()+"\n Codice Fiscale: "+this.codiceFiscale+"\n Numero CIE: "+this.codiceFiscale+"\n Auto attuale: "+this.autoAttuale.toString(); }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Privato){
            Privato r=(Privato) obj;
            return super.equals(r) && this.nomeCognome.equalsIgnoreCase(r.getNomeCognome()) && this.codiceFiscale.equalsIgnoreCase(r.getCodiceFiscale()) && this.numeroCie.equalsIgnoreCase(r.getNumeroCie()) && this.autoAttuale.equals(r.getAutoAttuale());
        }
        return false;
    }

    public boolean isValidCodiceFiscale(String codiceFiscale) { // Metodo per verificare se un codice fiscale è valido
        if (codiceFiscale == null || !codiceFiscale.matches("^[A-Z0-9]{16}$")) {  // Controllo che il codice fiscale sia lungo esattamente 16 caratteri
            return false;
        }
        return true;
        /* // Tabelle per il calcolo del carattere di controllo
        int[] valoriPari = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] valoriDispari = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 1, 0, 5, 7, 9, 13, 15, 17, 19, 21};
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // CALCOLO DELLA POSIZIONE%26 NELL?ALFABETO DEL CARATTERE DI CONTROLLO
        int somma = 0;
        for (int i = 0; i < 15; i++) {
            char c = codiceFiscale.charAt(i);
            if (i % 2 == 0) { // Posizione dispari (indice pari nel codice)
                somma += valoriDispari[alfabeto.indexOf(c) != -1 ? alfabeto.indexOf(c) : c - '0'];
            } else { // Posizione pari (indice dispari nel codice)
                somma += valoriPari[alfabeto.indexOf(c) != -1 ? alfabeto.indexOf(c) : c - '0'];
            }
        }
        char expectedCheckChar = alfabeto.charAt(somma % 26);// Calcolo del carattere di controllo
        return codiceFiscale.charAt(15) == expectedCheckChar;// Confronta il carattere di controllo calcolato con quello presente nel codice fiscale
        */
    }
    public boolean isValidNomeCognome(String nomeCognome){
        if (nomeCognome == null || nomeCognome.isEmpty()) {
            return false;
        }
        String regex = "^[A-Z][a-zàèéìòù'\\\\-]*([\\\\s][A-Z][a-zàèéìòù'\\\\-]*)*$";
        /* REGOLE REGEX SE NON LE RICORDI

        ^[A-Z]: Il nome o cognome deve iniziare con una lettera maiuscola.
        [a-zàèéìòù'\\-]*: Dopo la maiuscola, può seguire una sequenza di lettere minuscole, incluse lettere accentate (àèéìòù), apostrofo ('), o trattino (-).
        ([\\s][A-Z][a-zàèéìòù'\\-]*)*: Se ci sono altre parole (es. nei cognomi composti come "De Luca"), ognuna deve iniziare con una maiuscola seguita da lettere minuscole e caratteri validi.
        $: La stringa deve terminare qui (non sono ammessi caratteri aggiuntivi dopo).

        */
        return nomeCognome.matches(regex);
    }

    // Metodo per verificare la validità del numero CIE
    public boolean isValidCIE(String cie) {
        if (cie == null || cie.isEmpty()) {
            return false;
        }
        String regex = "^[A-Z]{2}\\d{7}$"; // Regex per il formato della CIE: due lettere seguite da sette cifre
        return cie.matches(regex);
    }
}
