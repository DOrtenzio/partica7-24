package com.example.pratica724.auto;

import com.example.pratica724.utenti.Utente;

import java.util.ArrayList;

public class RegistroAcquisti {
    private ArrayList<Auto> registroAcquistate;
    private ArrayList<Utente> registroAcquirenti;

    //Costruttore
    public RegistroAcquisti(ArrayList<Auto> registroAcquistate, ArrayList<Utente> registroAcquirenti) {
        this.registroAcquistate = registroAcquistate;
        this.registroAcquirenti = registroAcquirenti;
    }

    //get e set
    public ArrayList<Auto> getRegistroAcquistate() { return registroAcquistate; }
    public void setRegistroAcquistate(ArrayList<Auto> registroAcquistate) { this.registroAcquistate = registroAcquistate; }
    public ArrayList<Utente> getRegistroAcquirenti() { return registroAcquirenti; }
    public void setRegistroAcquirenti(ArrayList<Utente> registroAcquirenti) { this.registroAcquirenti = registroAcquirenti; }

    //Metodi
    //TODO: Inserire metodi come add remove o ricerca
}
