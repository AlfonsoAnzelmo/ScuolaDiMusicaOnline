package model.Carrello;

import model.Corso.Corso;
import model.StrumentiMusicali.StrumentiMusicali;
import model.Utente;

import java.util.ArrayList;

public class CarrelloBean {

    public ArrayList<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(ArrayList<Corso> corsi) {
        this.corsi = corsi;
    }

    public ArrayList<StrumentiMusicali> getStrumentiMusicali() {
        return strumentiMusicali;
    }

    public void setStrumentiMusicali(ArrayList<StrumentiMusicali> strumentiMusicali) {
        this.strumentiMusicali = strumentiMusicali;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }


    private Utente utente ;
    ArrayList<Corso> corsi ;
    ArrayList<StrumentiMusicali> strumentiMusicali ;
}
