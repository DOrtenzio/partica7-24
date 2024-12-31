package com.example.pratica724.auto;

import java.util.ArrayList;
import java.util.Collections;

public class InventarioAuto {
    public ArrayList<Auto> inventario;

    //Costruttore
    public InventarioAuto() {
        this.inventario = new ArrayList<Auto>();
    }

    //get e set
    public ArrayList<Auto> getInventario() { return inventario; }
    public void setInventario(ArrayList<Auto> inventario) { this.inventario = inventario; }

    //metodi
    @Override
    public String toString(){
        String s="AUTO DISPONIBILI: \n";
        for (Auto auto : inventario){
            s=s+auto.toString()+"\n |--------------------|";
        }
        return s;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof InventarioAuto){
            InventarioAuto r=(InventarioAuto) obj;
            if (r.getInventario().size() == this.inventario.size()) {
                for (int i = 0; i<this.inventario.size();i++) {
                    if (!r.getInventario().get(i).equals(inventario.get(i)))
                        return false;
                }
                return true;
            }else
                return false;
        }
        return false;
    }
    public void aggiungiAuto(Auto auto){ this.inventario.add(auto); }
    public boolean rimuoviAuto(Auto auto){
        if (this.inventario.contains(auto)){
            this.inventario.remove(auto);
            return true;
        }
        return false;
    }
    public void ordinaInBaseAlPrezzo(){ Collections.sort(this.inventario); }
    //Metodi di ricerca
    public ArrayList<Auto> ricerca(String marchio, String modello, int annoImmatricolazione, String alimentazione, String colore) {
        ArrayList<Auto> autoRicercate = new ArrayList<>();

        for (Auto auto : this.inventario) {
            boolean corrisponde = true;

            if (marchio != null && !auto.getMarca().equalsIgnoreCase(marchio)) {
                corrisponde = false;
            }
            if (modello != null && !auto.getModello().equalsIgnoreCase(modello)) {
                corrisponde = false;
            }
            if (colore != null && !auto.getColore().equalsIgnoreCase(colore)) {
                corrisponde = false;
            }
            if (annoImmatricolazione != 0 && auto.getAnnoImmatricolazione()!=annoImmatricolazione ) {
                corrisponde = false;
            }
            if (alimentazione != null && auto.getAlimentazione().equalsIgnoreCase(alimentazione) ) {
                corrisponde = false;
            }

            // Aggiungi l'auto se corrisponde a/ai criteri specificati
            if (corrisponde) {
                autoRicercate.add(auto);
            }
        }

        return autoRicercate;
    }
    public ArrayList<AutoNuova> ricercaAutoNuove(){
        ArrayList<AutoNuova> autoNuove =new ArrayList<AutoNuova>();
        for (Auto auto : this.inventario){
            if (auto instanceof  AutoNuova)
                autoNuove.add((AutoNuova) auto);
        }
        return autoNuove;
    }
    public ArrayList<AutoUsata> ricercaAutoUsate(){
        ArrayList<AutoUsata> autoUsate =new ArrayList<AutoUsata>();
        for (Auto auto : this.inventario){
            if (auto instanceof  AutoUsata)
                autoUsate.add((AutoUsata) auto);
        }
        return autoUsate;
    }
    public ArrayList<AutoSpeciali> ricercaAutoSpeciali(){
        ArrayList<AutoSpeciali> autoSpeciali =new ArrayList<AutoSpeciali>();
        for (Auto auto : this.inventario){
            if (auto instanceof  AutoSpeciali)
                autoSpeciali.add((AutoSpeciali) auto);
        }
        return autoSpeciali;
    }
    public ArrayList<AutoKm0> ricercaAutoKm0(){
        ArrayList<AutoKm0> autoKm0 =new ArrayList<AutoKm0>();
        for (Auto auto : this.inventario){
            if (auto instanceof  AutoKm0)
                autoKm0.add((AutoKm0) auto);
        }
        return autoKm0;
    }
    public ArrayList<AutoDisabili> ricercaAutoDisabili(){
        ArrayList<AutoDisabili> autoDisabili =new ArrayList<AutoDisabili>();
        for (Auto auto : this.inventario){
            if (auto instanceof  AutoDisabili)
                autoDisabili.add((AutoDisabili) auto);
        }
        return autoDisabili;
    }
}
