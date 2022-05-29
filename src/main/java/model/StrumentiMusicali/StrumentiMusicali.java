package model.StrumentiMusicali;


public class StrumentiMusicali {

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getImmaginePrincipalePercorso() {
        return immaginePrincipalePercorso;
    }

    public void setImmaginePrincipalePercorso(String immaginePrincipalePercorso) {
        this.immaginePrincipalePercorso = immaginePrincipalePercorso;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    private int codice , categoriaId , quantita;
    private String modello , immaginePrincipalePercorso ;
    private double prezzo ;


}
