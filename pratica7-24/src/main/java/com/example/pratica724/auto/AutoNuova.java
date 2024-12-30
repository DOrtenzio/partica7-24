package com.example.pratica724.auto;

import java.time.LocalDate;

public class AutoNuova extends Auto{
    private String optional;
    private int numeroOptional;

    public AutoNuova(String marca, String modello, double prezzo,String alimentazione, String optional) {
        super(marca, modello, prezzo,LocalDate.now().getYear(),alimentazione);
        this.optional=optional;
    }

    //Get e Set
    public String getOptional() { return optional; }
    public void setOptional(String optional) {
        String regex = "^[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*$"; // Regex per il formato parola-parola-parola-..
        if (optional.matches(regex))
            this.optional = optional;
        else
            this.optional="Nessuno";
    }
    public int getNumeroOptional() { return numeroOptional; }
    public void setNumeroOptional(String optional) {
        String[] parole = optional.split("-");
        this.numeroOptional=parole.length;
    }

    //metodi
    @Override
    public String toString(){ return super.toString()+"\n Optional: "+this.optional+"\n tot: "+this.numeroOptional; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof AutoNuova){
            AutoNuova r=(AutoNuova) obj;
            return super.equals(r) && this.optional.equalsIgnoreCase(r.getOptional()) ;
        }
        return false;
    }
}
