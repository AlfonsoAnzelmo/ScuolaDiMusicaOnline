package model.StrumentoMusicaleSpecifico;

public class StrumentoMusicaleSpecifico {


    public void setIdImmagine(int idImmagine) {
        this.idImmagine = idImmagine;
    }

    public int getIdImmagine() {
        return idImmagine;
    }

    public void setCodiceStrumento(int codiceStrumento) {
        this.codiceStrumento = codiceStrumento;
    }

    public int getCodiceStrumento() {
        return codiceStrumento;
    }

    public void setPercorsoImmagine(String percorsoImmagine) {
        this.percorsoImmagine = percorsoImmagine;
    }

    public String getPercorsoImmagine() {
        return percorsoImmagine;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }

    private int idImmagine , codiceStrumento ;
    private boolean principale ;
    private String percorsoImmagine ;
}
