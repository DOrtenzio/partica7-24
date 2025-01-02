package com.example.pratica724.auto;

import com.example.pratica724.utenti.Privato;

import java.util.ArrayList;

public class RegistroAcquisti {
    private ArrayList<Auto> registroAcquistate;
    private ArrayList<Privato> registroAcquirenti;

    //Costruttore
    public RegistroAcquisti() {
        this.registroAcquistate = new ArrayList<Auto>();
        this.registroAcquirenti = new ArrayList<Privato>();
    }

    //get e set
    public ArrayList<Auto> getRegistroAcquistate() { return registroAcquistate; }
    public void setRegistroAcquistate(ArrayList<Auto> registroAcquistate) { this.registroAcquistate = registroAcquistate; }
    public ArrayList<Privato> getRegistroAcquirenti() { return registroAcquirenti; }
    public void setRegistroAcquirenti(ArrayList<Privato> registroAcquirenti) { this.registroAcquirenti = registroAcquirenti; }

    //Metodi
    public void addAcquisto(Auto autoAcquistata, Privato acquirente){
        registroAcquistate.add(autoAcquistata);
        registroAcquirenti.add(acquirente);
    }
    public boolean cancellaAcquistata(Auto autoAcquistata){
        if (registroAcquistate.contains(autoAcquistata)) {
            registroAcquistate.remove(autoAcquistata);
            return true;
        }
        return false;
    }
    public boolean cancellaAcquirente(Privato acquirente){
        if (registroAcquirenti.contains(acquirente)) {
            registroAcquirenti.remove(acquirente);
            return true;
        }
        return false;
    }
    public boolean cancellaAcquisto(Auto autoAcquistata, Privato acquirente){ return cancellaAcquirente(acquirente) && cancellaAcquistata(autoAcquistata); }

    //Ricerche
    public ArrayList<Integer> ricercaAutoAcquistata(String marchio, String modello, int annoImmatricolazione, String alimentazione, String colore) {
        ArrayList<Integer> autoRicercate = new ArrayList<>();

        for (Auto auto : this.registroAcquistate) {
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
                autoRicercate.add(registroAcquistate.indexOf(auto));
            }
        }

        return autoRicercate;
    }
    public ArrayList<Integer> ricercaAcquirenti(String nomeUtente, String locazione, String email, String telefono, String nomeCognome, String numeroCie, String codiceFiscale) {
        ArrayList<Integer> privatiRicercati = new ArrayList<>();

        for (Privato privato : this.registroAcquirenti) {
            boolean corrisponde = true;

            if (nomeUtente != null && !privato.getNomeUtente().equalsIgnoreCase(nomeUtente)) {
                corrisponde = false;
            }
            if (locazione != null && !privato.getLocazione().equalsIgnoreCase(locazione)) {
                corrisponde = false;
            }
            if (email != null && !privato.getEmail().equalsIgnoreCase(email)) {
                corrisponde = false;
            }
            if (telefono != null && !privato.getTelefono().equalsIgnoreCase(telefono)) {
                corrisponde = false;
            }
            if (nomeCognome != null && !privato.getNomeCognome().equalsIgnoreCase(nomeCognome)) {
                corrisponde = false;
            }
            if (numeroCie != null && !privato.getNumeroCie().equalsIgnoreCase(numeroCie)) {
                corrisponde = false;
            }
            if (codiceFiscale != null && !privato.getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                corrisponde = false;
            }

            if (corrisponde) {
                privatiRicercati.add(registroAcquirenti.indexOf(privato));
            }
        }

        return privatiRicercati;
    }
}
