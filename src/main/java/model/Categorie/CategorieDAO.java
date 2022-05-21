package model.Categorie;

import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieDAO {

    public ArrayList<CategorieBean> doRetrieveAllCategories()
    {
        ArrayList<CategorieBean> s = new ArrayList<CategorieBean>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id , nome FROM categoria ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategorieBean c = new CategorieBean() ;
                c.setNome(rs.getString("nome"));
                c.setId(rs.getInt("id"));
                s.add(c) ;
            }
            return s ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public byte[] doRetrieveCategoriaImage(int id)
    {
        byte[]img = null ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT immagine FROM categoria where id = ?");

            ps.setInt(1 , id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                img = rs.getBytes(1);
            }
            return img ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
