package model.StrumentiMusicali;

import model.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class StrumentiMusicaliDAO {
    public ArrayList<StrumentiMusicali> doRetrieveByCodice(int id)
    {
        ArrayList<StrumentiMusicali> strumentiMusicali = new ArrayList<StrumentiMusicali>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT Codice , Nome ," +
                            "Tipo , CategoriaId , immagine , modello , quantita ," +
                            "prezzo , immaginePrincipale FROM strumentimusicali where id = ?");

            ps.setInt(1 , id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StrumentiMusicali musicali = new StrumentiMusicali() ;
                musicali.setCodice(rs.getInt("codice"));
                musicali.setNome(rs.getString("nome"));
                musicali.setTipo(rs.getString("tipo"));
                musicali.setCategoria(rs.getInt("CategoriaId"));
                musicali.setImmagineId(rs.getInt("immagine"));
                musicali.setModello(rs.getString("modello"));
                musicali.setQuantita(rs.getInt("quantita"));
                musicali.setPrezzo(rs.getDouble("prezzo"));

                Blob blob = rs.getBlob("immaginePrincipale");
                musicali.setImmaginePrincipale(blob.getBinaryStream());

                strumentiMusicali.add(musicali) ;
            }
            return strumentiMusicali ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<StrumentiMusicali> doRetrieveByNome(String nome)
    {
        ArrayList<StrumentiMusicali> strumentiMusicali = new ArrayList<StrumentiMusicali>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT Codice , Nome ," +
                            "Tipo , CategoriaId , immagine , modello , quantita ," +
                            "prezzo , immaginePrincipale FROM strumentimusicali where nome = ?");

            ps.setString(1 , nome);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StrumentiMusicali musicali = new StrumentiMusicali() ;
                musicali.setCodice(rs.getInt("codice"));
                musicali.setNome(rs.getString("nome"));
                musicali.setTipo(rs.getString("tipo"));
                musicali.setCategoria(rs.getInt("CategoriaId"));
                musicali.setImmagineId(rs.getInt("immagine"));
                musicali.setModello(rs.getString("modello"));
                musicali.setQuantita(rs.getInt("quantita"));
                musicali.setPrezzo(rs.getDouble("prezzo"));

                Blob blob = rs.getBlob("immaginePrincipale");
                musicali.setImmaginePrincipale(blob.getBinaryStream());

                strumentiMusicali.add(musicali) ;
            }
            return strumentiMusicali ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
