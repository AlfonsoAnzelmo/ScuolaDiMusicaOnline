package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CategorieStrumento.CategorieStrumentoBean;
import model.CategorieStrumento.CategorieStrumentoDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategorieStrumento", value = "/CategorieStrumento")


public class CategorieStrumento extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        CategorieStrumentoDAO categorieDAO = new CategorieStrumentoDAO() ;

        ArrayList<CategorieStrumentoBean> CategorieStrumento = categorieDAO.doRetrieveAllCategories() ;

        request.setAttribute("CategorieStrumento" , CategorieStrumento);
        RequestDispatcher rd = request.getRequestDispatcher("CategorieStrumento.jsp") ;
        rd.forward(request , response) ;

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}