package com.example.pratica724.auto;

import java.time.LocalDate;

public class Auto implements Comparable<Auto>{
    private String marca, modello, alimentazione,colore,descrizione;
    private double prezzo;
    private int annoImmatricolazione;

    //Costruttore
    public Auto(String marca, String modello, double prezzo,int annoImmatricolazione, String alimentazione,String colore,String descrizione) {
        this.marca = marca;
        this.modello = modello;
        this.alimentazione=alimentazione;
        this.colore=colore;
        this.descrizione=descrizione;
        setAnnoImmatricolazione(annoImmatricolazione);
        setPrezzo(prezzo);
    }

    //Get e set
    public String getMarca() { return marca; }
    public String getModello() { return modello; }
    public double getPrezzo() { return prezzo; }
    public int getAnnoImmatricolazione() { return annoImmatricolazione; }
    public String getAlimentazione() { return alimentazione; }
    public String getColore() { return colore; }
    public String getDescrizione() { return descrizione; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModello(String modello) { this.modello = modello; }
    public void setPrezzo(double prezzo){
        if (prezzo<0)
            this.prezzo=0;
        else
            this.prezzo=prezzo;
    }
    public void setAnnoImmatricolazione(int annoImmatricolazione) {
        if (annoImmatricolazione<1900)
            this.annoImmatricolazione = 0;
        else
            this.annoImmatricolazione = annoImmatricolazione;
    }
    public void setAlimentazione(String alimentazione) { this.alimentazione = alimentazione; }
    public void setColore(String colore) { this.colore = colore; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    //Metodi
    @Override
    public String toString(){ return "Marca: "+this.marca+"\n Modello: "+this.modello+"\n Anno Immatricolazione : "+this.annoImmatricolazione+"\n Alimentazione: "+this.alimentazione+"\n Colore: "+this.colore+"\n Descrizione: "+this.descrizione+"\n Prezzo : "+this.prezzo; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Auto){
            Auto r=(Auto) obj;
            return super.equals(r) && this.marca.equalsIgnoreCase(r.getMarca()) && this.modello.equalsIgnoreCase(r.getModello()) && this.annoImmatricolazione==r.getAnnoImmatricolazione() && this.alimentazione.equalsIgnoreCase(r.getAlimentazione()) && this.colore.equalsIgnoreCase(r.getColore()) && this.descrizione.equalsIgnoreCase(r.getDescrizione()) && this.prezzo==r.getPrezzo();
        }
        return false;
    }
    @Override
    public int compareTo(Auto o) {
        if (this.prezzo < o.getPrezzo())
            return -1;
        else if (this.prezzo == o.getPrezzo())
            return 0;
        else
            return 1;
    }
}
