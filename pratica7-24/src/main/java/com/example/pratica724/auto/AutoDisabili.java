package com.example.pratica724.auto;

public class AutoDisabili extends AutoSpeciali{
    private double larghezzaMaxCarrozzina;

    //Costruttore
    public AutoDisabili(String marca, String modello, double prezzo, int annoImmatricolazione, String alimentazione,String colore,String descrizione, String aggiunte, double incentivo, double larghezzaMaxCarrozzina) {
        super(marca, modello, prezzo, annoImmatricolazione, alimentazione,colore,descrizione,aggiunte, incentivo);

    }

    //get e set
    public double getLarghezzaMaxCarrozzina() { return larghezzaMaxCarrozzina; }
    public void setLarghezzaMaxCarrozzina(double larghezzaMaxCarrozzina) {
        if (larghezzaMaxCarrozzina < 50.0)
            this.larghezzaMaxCarrozzina = 50.0;
        else
            this.larghezzaMaxCarrozzina = larghezzaMaxCarrozzina;
    }

    //metodi
    @Override
    public String toString(){ return super.toString()+"\n Larghezza massima carrozzina: "+this.larghezzaMaxCarrozzina; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof AutoDisabili){
            AutoDisabili r=(AutoDisabili) obj;
            return super.equals(r) && this.larghezzaMaxCarrozzina == r.getLarghezzaMaxCarrozzina();
        }
        return false;
    }
}
