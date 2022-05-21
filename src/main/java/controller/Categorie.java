package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categorie.CategorieBean;
import model.Categorie.CategorieDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Categorie", value = "/Categorie")


public class Categorie extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        CategorieDAO categorieDAO = new CategorieDAO() ;

        ArrayList<CategorieBean> categorie = categorieDAO.doRetrieveAllCategories() ;

        request.setAttribute("categorie" , categorie);
        RequestDispatcher rd = request.getRequestDispatcher("Categorie.jsp") ;
        rd.forward(request , response) ;

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}