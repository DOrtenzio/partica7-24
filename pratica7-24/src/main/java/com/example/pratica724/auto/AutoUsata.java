package com.example.pratica724.auto;

public class AutoUsata extends Auto{
    private int chilometraggio;

    //Costruttore
    public AutoUsata(String marca, String modello, double prezzo, int annoImmatricolazione,String alimentazione, int chilometraggio,String colore,String descrizione) {
        super(marca, modello, prezzo, annoImmatricolazione,alimentazione,colore,descrizione);
        setChilometraggio(chilometraggio);
    }

    //get e set
    public int getChilometraggio() { return chilometraggio; }
    public void setChilometraggio(int chilometraggio) {
        if (chilometraggio<0)
            this.chilometraggio = 0;
        else
            this.chilometraggio=chilometraggio;
    }

    //metodi
    @Override
    public String toString(){ return super.toString()+"\n Chilometraggio: "+this.chilometraggio; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof AutoUsata){
            AutoUsata r=(AutoUsata) obj;
            return super.equals(r) && this.chilometraggio == r.getChilometraggio() ;
        }
        return false;
    }
}
