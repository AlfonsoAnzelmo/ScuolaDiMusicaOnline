package model.CategorieStrumento;

import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieStrumentoDAO {

    public ArrayList<CategorieStrumentoBean> doRetrieveAllCategories()
    {
        ArrayList<CategorieStrumentoBean> s = new ArrayList<CategorieStrumentoBean>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM categoriastrumentimusicali ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategorieStrumentoBean c = new CategorieStrumentoBean() ;
                c.setNome(rs.getString("nome"));
                c.setId(rs.getInt("id"));
                c.setPercorso(rs.getString("immagine"));
                s.add(c) ;
            }
            return s ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
