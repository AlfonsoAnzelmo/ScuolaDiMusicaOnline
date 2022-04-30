package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CategorieEprodotti.CategorieDAO;
import model.ConPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet(name = "downloadImageCategoria", value = "/downloadImageCategoria")
public class downloadImageCategoria extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("image/jpg");

        int id = Integer.parseInt(request.getParameter("id"));

        byte[] img = null;
        ServletOutputStream sos = null;

        CategorieDAO categorieDAO = new CategorieDAO();
        img = categorieDAO.doRetrieveCategoriaImage(id);


        ServletOutputStream servletOutputStream = response.getOutputStream();

        servletOutputStream.write(img);

        servletOutputStream.close();
    }
}