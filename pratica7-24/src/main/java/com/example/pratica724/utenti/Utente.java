package com.example.pratica724.utenti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Utente {
    private String nomeUtente,locazione,email,telefono,dataRegistrazione;

    //Costruttore
    public Utente(String nomeUtente, String locazione, String email, String telefono) {
        this.nomeUtente = nomeUtente;
        this.locazione = locazione;
        setEmail(email);
        this.dataRegistrazione = ottieniData();
        setTelefono(telefono);
    }

    //get e set
    public String getNomeUtente() { return nomeUtente; }
    public void setNomeUtente(String nomeUtente) { this.nomeUtente = nomeUtente; }

    public String getLocazione() { return locazione; }
    public void setLocazione(String locazione) { this.locazione = locazione; }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (isEmailValida(email))
            this.email = email;
        else
            this.email = null;
    }
    public String getDataRegistrazione() { return dataRegistrazione; } //Solo get perchè essa è impostata automaticamente e sarebbe inutile cambiarla

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        if (isNumeroValido(telefono))
            this.telefono = telefono;
        else
            this.telefono = null;
    }

    //Metodi
    private String ottieniData(){
        LocalDate dataCorrente = LocalDate.now(); // Ottieni la data attuale
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definisci il formato desiderato giorni-mese-anno
        return dataCorrente.format(formatter); // Applica la formattazione alla data;
    }

    // Metodo per verificare se la stringa è nel formato email
    private boolean isEmailValida(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex); // Restituisce true se l'email corrisponde al pattern, altrimenti false
    }

    // Metodo per verificare se un numero di telefono è valido
    public  boolean isNumeroValido(String numeroDiTelefono) {
        String telefonoRegex = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{1,4}\\)?[- ]?\\d{1,4}[- ]?\\d{1,4}$"; // La regex permette numeri con prefisso internazionale (opzionale) e numeri separati da spazi, trattini o parentesi
        return telefono.matches(telefonoRegex);
    }
    @Override
    public String toString(){ return "NomeUtente: "+this.nomeUtente+"\n Locazione attuale: "+this.nomeUtente+"\n Email: "+this.email+"\n Telefono: "+this.telefono+"\n Data di registrazione: "+this.dataRegistrazione; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Utente){
            Utente r=(Utente) obj;
            return this.nomeUtente.equalsIgnoreCase(r.getNomeUtente()) && this.locazione.equalsIgnoreCase(r.getLocazione()) && this.email.equalsIgnoreCase(r.getEmail()) && this.telefono.equalsIgnoreCase(r.getTelefono()) && this.dataRegistrazione.equalsIgnoreCase(r.getDataRegistrazione());
        }
        return false;
    }
}
