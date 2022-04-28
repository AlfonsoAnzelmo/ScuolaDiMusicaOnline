package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;
@WebServlet(name = "Login", value = "/Login")

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String email = request.getParameter("email") ;
        String password = request.getParameter("password") ;


        Utente utente = new Utente() ;

        utente.setEmail(email);
        utente.setPassword(password);

        UtenteDAO utenteDAO = new UtenteDAO() ;
        utente = utenteDAO.doRetrieveByEmail_Password(email , password) ;
        if(utente == null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pagine/nonSeiRegistrato.jsp") ;
            rd.forward(request , response) ;
        }
        else
        {
            request.setAttribute("utente" , utente);
            
            RequestDispatcher rd = request.getRequestDispatcher("paginaIniziale.jsp") ;
            rd.forward(request , response) ;
        }


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request , response);
    }
    public void destroy() {
    }
}
