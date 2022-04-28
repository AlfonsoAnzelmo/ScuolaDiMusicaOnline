package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Corso.CorsoDAO;


import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Catalogo", value = "/Catalogo")


public class Catalogo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request , response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        CorsoDAO corsoDAO = new CorsoDAO() ;
        ArrayList<String> listaCategorie = corsoDAO.doRetrieveAllCategories() ;

        request.setAttribute("listaCategorie" , listaCategorie);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pagine/catalogo.jsp") ;
        rd.forward(request , response) ;
    }
}
