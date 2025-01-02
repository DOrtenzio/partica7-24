package com.example.pratica724.auto;

import java.time.LocalDate;
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
    public double scontoPermuta(double valoreAutoNuova, AutoUsata autoDaVendere){
        if (autoDaVendere.getAnnoImmatricolazione() > LocalDate.now().getYear()-2){ //Se auto è degli ultimi due anni
            if (autoDaVendere.getAlimentazione().equalsIgnoreCase("benzina") || autoDaVendere.getAlimentazione().equalsIgnoreCase("disel")){
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.1+0.01+0.0003);
                else
                    return valoreAutoNuova*(0.1+0.01+0.00003);
            }else{
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.1+0.05+0.0003);
                else
                    return valoreAutoNuova*(0.1+0.05+0.00003);
            }
        } else if (autoDaVendere.getAnnoImmatricolazione() > LocalDate.now().getYear()-5) {
            if (autoDaVendere.getAlimentazione().equalsIgnoreCase("benzina") || autoDaVendere.getAlimentazione().equalsIgnoreCase("disel")){
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.06+0.001+0.0003);
                else
                    return valoreAutoNuova*(0.06+0.001+0.00003);
            }else{
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.06+0.005+0.0003);
                else
                    return valoreAutoNuova*(0.06+0.005+0.00003);
            }
        } else if (autoDaVendere.getAnnoImmatricolazione() > LocalDate.now().getYear()-10) {
            if (autoDaVendere.getAlimentazione().equalsIgnoreCase("benzina") || autoDaVendere.getAlimentazione().equalsIgnoreCase("disel")){
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.04+0.0001+0.0003);
                else
                    return valoreAutoNuova*(0.04+0.0001+0.00003);
            }else{
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.04+0.0005+0.0003);
                else
                    return valoreAutoNuova*(0.04+0.0005+0.00003);
            }
        }else {
            if (autoDaVendere.getAlimentazione().equalsIgnoreCase("benzina") || autoDaVendere.getAlimentazione().equalsIgnoreCase("disel")){
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.01+0.00001+0.0003);
                else
                    return valoreAutoNuova*(0.01+0.00001+0.00003);
            }else{
                if (autoDaVendere.getChilometraggio()<50000)
                    return valoreAutoNuova*(0.01+0.00005+0.0003);
                else
                    return valoreAutoNuova*(0.01+0.00005+0.00003);
            }
        }
    }
}
