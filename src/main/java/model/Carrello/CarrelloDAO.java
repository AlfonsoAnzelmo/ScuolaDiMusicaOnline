package model.Carrello;

import model.ConPool;
import model.Corso.Corso;
import model.StrumentiMusicali.StrumentiMusicali;
import model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrelloDAO {



    public CarrelloBean doRetrieveAll(int idUtente)
    {
        CarrelloBean c = new CarrelloBean() ;
        ArrayList<Corso> corsi = new ArrayList<Corso>() ;
        ArrayList<StrumentiMusicali> strumentiMusicali = new ArrayList<StrumentiMusicali>() ;

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("Select *" +
                            "from corso c , carrello ca , strumentimusicali str , utente u " +
                            "Where ca.UtenteID = u.ID" +
                            " AND ca.Corso = c.Codice" +
                            " AND ca.CodiceStrumentoMusicale = str.Codice" +
                            " AND ca.UtenteID = ? ; ");

            ps.setInt(1 , idUtente);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Corso corso = new Corso() ;
                corso.setNumeroIscritti(rs.getInt("NumeroIscritti"));
                corso.setDurata(rs.getInt("Durata")) ;
                corso.setNome(rs.getString("Nome")) ;
                corso.setCodice(rs.getInt("Codice")) ;
                corso.setInsegnante(rs.getInt(("Insegnante"))) ;
                corso.setNumeroLezioni(rs.getInt("NumeroLezioni")) ;
                corso.setCostoTotale(rs.getDouble("CostoTot")) ;
                corso.setCategoria(rs.getString("Categoria")) ;
                corsi.add(corso) ;

                Utente utente = new Utente() ;
                utente.setId(rs.getInt("ID"));
                utente.setNome(rs.getString("Nome")) ;
                utente.setCognome(rs.getString("Cognome")) ;
                utente.setDataNascita(rs.getString("DataNascita")); ;
                utente.setEmail(rs.getString("Email")); ;
                utente.setPassword(rs.getString("Password")); ;
                utente.setVia(rs.getString("Via")); ;
                utente.setCitta(rs.getString("Citta")); ;
                utente.setCap(rs.getString("Cap")); ;
                utente.setNumeroTelefono(rs.getString("NumeroTelefono")); ;

                StrumentiMusicali strumentoMusicale = new StrumentiMusicali() ;
                strumentoMusicale.setCodice(rs.getInt("Codice"));
                strumentoMusicale.setModello(rs.getString("modello"));
                strumentoMusicale.setPrezzo(rs.getDouble("prezzo"));
                strumentoMusicale.setQuantita(rs.getInt("quantita"));
                strumentoMusicale.setImmaginePrincipalePercorso(rs.getString("immaginePrincipale"));
                strumentoMusicale.setCategoriaId(rs.getInt("CategoriaId"));
                strumentiMusicali.add(strumentoMusicale) ;

                c.setCorsi(corsi);
                c.setUtente(utente);
                c.setStrumentiMusicali(strumentiMusicali);

            }
            return c ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
