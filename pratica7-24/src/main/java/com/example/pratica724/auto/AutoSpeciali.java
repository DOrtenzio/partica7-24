package com.example.pratica724.auto;

public class AutoSpeciali extends Auto{
    private String aggiunte;
    private double incentivo;

    //costruttore
    public AutoSpeciali(String marca, String modello, double prezzo, int annoImmatricolazione, String alimentazione,String colore,String descrizione, String aggiunte, double incentivo) {
        super(marca, modello, prezzo, annoImmatricolazione, alimentazione,colore,descrizione);
        this.aggiunte = aggiunte;
        setIncentivo(incentivo);
    }

    //get e set
    public String getAggiunte() { return aggiunte; }
    public void setAggiunte(String aggiunte) { this.aggiunte = aggiunte; }
    public double getIncentivo() { return incentivo; }
    public void setIncentivo(double incentivo) {
        if (incentivo<0)
            this.incentivo = 0;
        else
            this.incentivo = incentivo;
    }

    //metodi
    @Override
    public String toString(){ return super.toString()+"\n Aggiunte: "+this.aggiunte+"\n Incentivo: "+this.incentivo; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof AutoSpeciali){
            AutoSpeciali r=(AutoSpeciali) obj;
            return super.equals(r) && this.aggiunte.equalsIgnoreCase(r.getAggiunte()) && this.incentivo == r.getIncentivo();
        }
        return false;
    }
}
