package model.StrumentiMusicali;

import java.io.InputStream;

public class StrumentiMusicali {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getImmagineId() {
        return immagineId;
    }

    public void setImmagineId(int immagineId) {
        this.immagineId = immagineId;
    }
    public InputStream getImmaginePrincipale() {
        return immaginePrincipale;
    }

    public void setImmaginePrincipale(InputStream immaginePrincipale) {
        this.immaginePrincipale = immaginePrincipale;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private String nome , modello , tipo ;
    private int codice, categoria , quantita , immagineId ;
    private double prezzo ;
    private InputStream immaginePrincipale ;


}
