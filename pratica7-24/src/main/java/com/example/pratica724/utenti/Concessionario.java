package com.example.pratica724.utenti;

import com.example.pratica724.auto.*;

public class Concessionario extends Utente{
    private String nomeAzienda,sedeLegale,pIva,ragioneSociale;
    private InventarioAuto inventario;
    private RegistroAcquisti registroAcquisti;

    //Costruttori
    public Concessionario(String nomeUtente, String locazione, String email, String telefono, String nomeAzienda, String sedeLegale, String pIva, String ragioneSociale, InventarioAuto inventario, RegistroAcquisti registroAcquisti) {
        super(nomeUtente, locazione, email, telefono);
        this.nomeAzienda = nomeAzienda;
        this.sedeLegale = sedeLegale;
        setpIva(pIva);
        setRagioneSociale(ragioneSociale);
        this.inventario = inventario;
        this.registroAcquisti=registroAcquisti;
    }

    //Get e set
    public String getNomeAzienda() { return nomeAzienda; }
    public void setNomeAzienda(String nomeAzienda) { this.nomeAzienda = nomeAzienda; }
    public String getSedeLegale() { return sedeLegale; }
    public void setSedeLegale(String sedeLegale) { this.sedeLegale = sedeLegale; }
    public String getpIva() { return pIva; }
    public void setpIva(String pIva) {
        if (isValidPartitaIVA(pIva))
            this.pIva = pIva;
        else
            this.pIva = null;
    }
    public String getRagioneSociale() { return ragioneSociale; }
    public void setRagioneSociale(String ragioneSociale) {
        if (isValidRagioneSociale(ragioneSociale))
            this.ragioneSociale = ragioneSociale;
        else
            this.ragioneSociale = null;
    }
    public InventarioAuto getInventario() { return inventario; }
    public void setInventario(InventarioAuto inventario) { this.inventario = inventario; }
    public RegistroAcquisti getRegistroAcquisti() { return registroAcquisti; }
    public void setRegistroAcquisti(RegistroAcquisti registroAcquisti) { this.registroAcquisti = registroAcquisti; }

    //Metodi
    @Override
    public String toString(){ return "CONCESSIONARIA: "+this.nomeAzienda+super.toString()+"\n Sede Legale: "+this.sedeLegale+"\n Partita Iva: "+this.pIva+"\n Ragione Sociale: "+this.ragioneSociale; }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Concessionario){
            Concessionario r=(Concessionario) obj;
            return super.equals(r) && this.nomeAzienda.equalsIgnoreCase(r.getNomeAzienda()) && this.sedeLegale.equalsIgnoreCase(r.getSedeLegale()) && this.pIva.equalsIgnoreCase(r.getpIva()) && this.ragioneSociale.equalsIgnoreCase(r.getRagioneSociale()) && this.inventario.equals(r.getInventario()) && this.registroAcquisti.equals(r.getRegistroAcquisti());
        }
        return false;
    }
    // Metodo per verificare se una partita IVA è valida (x l'italia)
    private boolean isValidPartitaIVA(String partitaIVA) {

        // Controllo che la partita IVA sia composta esattamente da 11 cifre
        if (partitaIVA == null || !partitaIVA.matches("\\d{11}")) {
            return false;
        }

        //ALGORITMO DI CALCOLO CIFRA DI CONTROLLO (ULTIMA o 11esima)

        /*
        X = somma delle prime cinque cifre in posizione dispari
        Y = (somma dei doppi delle cinque cifre in posizione pari) - (9 se il doppio della cifra è superiore a 9)
        T = (X+Y) mod 10 ---> Somma modulo 10
        Allora la cifra di controllo C = (10-T) mod 10
        */

        //Converto in cifre singole per facilitare i calcoli
        int[] cifre = new int[11];
        for (int i = 0; i < partitaIVA.length(); i++) {
            cifre[i] = Character.getNumericValue(partitaIVA.charAt(i));
        }

        // Calcolo della cifra di controllo
        int T = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) { // Dispari
                T += cifre[i]; // cifre[i] = X
            } else { // Pari
                int doppioDellaCifra = cifre[i] * 2;
                if (doppioDellaCifra > 9) {
                    T += doppioDellaCifra - 9;
                } else {
                    T += doppioDellaCifra;
                } // == Y
            }
        }

        // Verifica della cifra di controllo

        /*
        Sia X la somma delle cifre in posizione dispari non considerando l'ultima cifra (che è di controllo)
        Sia Y la somma dei doppi delle cifre in posizione pari
        Sia Z il numero di volte che nei numeri in posizione pari c'è un valore maggiore o uguale a 5
        Sia T=(X+Y+Z) mod 10 l'unità corrispondente alla somma dei numeri sopra calcolati, allora la cifra di controllo C = (10 - T) mod 10
        */
        int cifraDiControllo = (10 - (T % 10)) % 10;

        return cifraDiControllo == cifre[10];
    }

    // Metodo per verificare se una ragione sociale è valida
    private boolean isValidRagioneSociale(String ragioneSociale) {
        if (ragioneSociale == null || ragioneSociale.isEmpty()) {  // Controllo che la ragione sociale non sia nulla o vuota
            return false;
        }
        String regex = "^[a-zA-Z0-9&\\-\\.\\'\\s]{2,100}$";// Consente lettere, numeri, spazi (\\s), caratteri &, -, ., '.
        return ragioneSociale.matches(regex);
    }
}
