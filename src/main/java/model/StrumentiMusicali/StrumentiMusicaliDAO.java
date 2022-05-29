package model.StrumentiMusicali;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class StrumentiMusicaliDAO {


    public ArrayList<StrumentiMusicali> doRetrieveByCategoriaId(int categoriaId)
    {
        ArrayList<StrumentiMusicali> strumentiMusicali = new ArrayList<StrumentiMusicali>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM strumentimusicali where CategoriaId = ?");

            ps.setInt(1 , categoriaId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StrumentiMusicali musicali = new StrumentiMusicali() ;
                musicali.setCodice(rs.getInt("codice"));
                musicali.setCategoriaId(rs.getInt("CategoriaId"));
                musicali.setModello(rs.getString("modello"));
                musicali.setQuantita(rs.getInt("quantita"));
                musicali.setPrezzo(rs.getDouble("prezzo"));
                musicali.setImmaginePrincipalePercorso(rs.getString("immaginePrincipale"));

                strumentiMusicali.add(musicali) ;
            }
            return strumentiMusicali ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
