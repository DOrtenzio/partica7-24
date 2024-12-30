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
    //TODO: Inserire metodo ricerca
}
