package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello.CarrelloBean;
import model.Carrello.CarrelloDAO;

import java.io.IOException;

@WebServlet(name = "Carrello", value = "/Carrello")
public class Carrello extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request , response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int idUtente = Integer.parseInt(request.getParameter("idUtente"));
        CarrelloDAO carrelloDAO = new CarrelloDAO() ;
        CarrelloBean carrelli = carrelloDAO.doRetrieveAll(idUtente) ;

        request.setAttribute("carrelli" , carrelli);

        RequestDispatcher rd = request.getRequestDispatcher("Carrello.jsp") ;
        rd.forward(request , response) ;
    }
}
