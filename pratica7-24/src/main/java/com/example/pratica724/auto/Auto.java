package com.example.pratica724.auto;

public class Auto implements Comparable<Auto>{
    private String marca, modello, alimentazione;
    private double prezzo;
    private int annoImmatricolazione;

    //Costruttore
    public Auto(String marca, String modello, double prezzo,int annoImmatricolazione, String alimentazione) {
        this.marca = marca;
        this.modello = modello;
        this.alimentazione=alimentazione;
        setAnnoImmatricolazione(annoImmatricolazione);
        setPrezzo(prezzo);
    }

    //Get e set
    public String getMarca() { return marca; }
    public String getModello() { return modello; }
    public double getPrezzo() { return prezzo; }
    public int getAnnoImmatricolazione() { return annoImmatricolazione; }
    public String getAlimentazione() { return alimentazione; }

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

    //Metodi
    @Override
    public String toString(){ return "Marca: "+this.marca+"\n Modello: "+this.modello+"\n Anno Immatricolazione : "+this.annoImmatricolazione+"\n Alimentazione: "+this.alimentazione+"\n Prezzo : "+this.prezzo; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Auto){
            Auto r=(Auto) obj;
            return super.equals(r) && this.marca.equalsIgnoreCase(r.getMarca()) && this.modello.equalsIgnoreCase(r.getModello()) && this.annoImmatricolazione==r.getAnnoImmatricolazione() && this.prezzo==r.getPrezzo();
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
