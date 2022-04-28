package model.Corso;

import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CorsoDAO {


    public ArrayList<String> doRetrieveAllCategories()
    {
        ArrayList<String> s = new ArrayList<String>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT distinct categoria FROM Corso ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               s.add(rs.getString("categoria")) ;
            }
            return s ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Corso> doRetrieveAll() {
        ArrayList<Corso> elencoCorsi = new ArrayList<Corso>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Corso ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Corso corso = new Corso();
                corso.setCodice(rs.getInt(1));
                corso.setNumeroLezioni(rs.getInt(2));
                corso.setNumeroIscritti(rs.getInt(3));
                corso.setCostoTotale(rs.getDouble(4));
                corso.setInsegnante(rs.getInt(5));
                corso.setNome(rs.getString(6));
                corso.setDurata(rs.getInt(7));
                elencoCorsi.add(corso) ;
            }
            return elencoCorsi ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doSave(Corso corso) {

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Corso (NumeroLezioni , Insegnante , Nome , Durata) VALUES" +
                            "(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, corso.getNumeroLezioni());
            ps.setInt(2, corso.getInsegnante());
            ps.setString(3, corso.getNome());
            ps.setInt(4, corso.getDurata());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

