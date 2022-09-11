package model.StrumentoMusicaleSpecifico;

import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StrumentoMusicaleSpecificoDAO {

    public ArrayList<StrumentoMusicaleSpecifico> doRetrieveByCodice(int codice) {
        ArrayList<StrumentoMusicaleSpecifico> strumentiMusicali =
                new ArrayList<>();

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM strumentimusicaliimmagini where Codice = ?");

            ps.setInt(1, codice);

            ResultSet rs = ps.executeQuery() ;
            while(rs.next())
            {
                StrumentoMusicaleSpecifico o = new StrumentoMusicaleSpecifico() ;
                o.setIdImmagine(rs.getInt("id")) ;
                o.setCodiceStrumento(rs.getInt("Codice"));
                o.setPercorsoImmagine(rs.getString("immagini"));
                o.setPrincipale(rs.getBoolean("principale"));
                strumentiMusicali.add(o) ;
            }


        }catch (SQLException e){e.printStackTrace();}
        return strumentiMusicali ;
    }



/* inutile perchè è molto piu semplice col campo "principale" in strumentiMusicaliImmagini
    public ArrayList<StrumentoMusicaleSpecifico> doRetrieveImmaginePrincipale() {
        ArrayList<StrumentoMusicaleSpecifico> principale = new ArrayList<>();

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("Select * From strumentimusicali s , strumentimusicaliimmagini si" +
                            "                  where s.Codice = si.Codice " +
                            "                   AND si.immagini = s.immaginePrincipale ");

            ResultSet rs = ps.executeQuery() ;
            while(rs.next()) {
                StrumentoMusicaleSpecifico sms = new StrumentoMusicaleSpecifico();
                sms.setIdImmagine(rs.getInt("si.id"));
                sms.setCodiceStrumento(rs.getInt("si.Codice"));
                sms.setPercorsoImmagine(rs.getString("immagini"));
                principale.add(sms);
            }
        } catch (SQLException e) {e.printStackTrace();}
        return principale ;
    }
*/
}
