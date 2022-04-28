package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UtenteDAO {
      public Utente doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT *" +
                            " FROM Utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setDataNascita(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setPassword(rs.getString(6));
                p.setVia(rs.getString(7));
                p.setCitta(rs.getString(8));
                p.setCap(rs.getString(9));
                p.setNumeroTelefono(rs.getString(10));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Utente utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Utente (Nome, Cognome , DataNascita , Email , Password , Via , Citta , Cap , NumeroTelefono) VALUES" +
                            "(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getDataNascita());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPassword());
            ps.setString(6, utente.getVia());
            ps.setString(7, utente.getCitta()) ;
            ps.setString(8, utente.getCap());
            ps.setString(9, utente.getNumeroTelefono());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByEmail_Password(String email , String password)
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT *" +
                            " FROM Utente WHERE email=? AND password =?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setDataNascita(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setPassword(rs.getString(6));
                p.setVia(rs.getString(7));
                p.setCitta(rs.getString(8));
                p.setCap(rs.getString(9));
                p.setNumeroTelefono(rs.getString(10));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByEmail(String email)
    {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT *" +
                            " FROM Utente WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setDataNascita(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setPassword(rs.getString(6));
                p.setVia(rs.getString(7));
                p.setCitta(rs.getString(8));
                p.setCap(rs.getString(9));
                p.setNumeroTelefono(rs.getString(10));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

