package model.Corso;

public class Corso {

    public Corso() {}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodice() {
        return Codice;
    }

    public void setCodice(int codice) {
        Codice = codice;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getInsegnante() {
        return Insegnante;
    }

    public void setInsegnante(int insegnante) {
        Insegnante = insegnante;
    }

    public int getNumeroLezioni() {
        return numeroLezioni;
    }

    public void setNumeroLezioni(int numeroLezioni) {
        this.numeroLezioni = numeroLezioni;
    }

    public int getNumeroIscritti() {
        return NumeroIscritti;
    }

    public void setNumeroIscritti(int numeroIscritti) {
        NumeroIscritti = numeroIscritti;
    }

    public double getCostoTotale() {
        return CostoTotale;
    }

    public void setCostoTotale(double costoTotale) {
        CostoTotale = costoTotale;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private String nome , categoria;
    private int  durata ,Codice, Insegnante ,numeroLezioni , NumeroIscritti ;
    private double CostoTotale ;
}
