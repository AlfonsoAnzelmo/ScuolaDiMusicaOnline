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



@WebServlet(name = "Register", value = "/Register")

public class Register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        String nome = request.getParameter("nome") ;
        String cognome = request.getParameter("cognome") ;
        String dataNascita = request.getParameter("dataNascita") ;
        String email = request.getParameter("email") ;
        String password = request.getParameter("password") ;
        String cap = request.getParameter("cap") ;
        String via = request.getParameter("via") ;
        String citta = request.getParameter("citta") ;
        String numeroTelefono = request.getParameter("numeroTelefono") ;



        Utente utente = new Utente() ;
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setDataNascita(dataNascita);
        utente.setCap(cap);
        utente.setCitta(citta);
        utente.setVia(via);
        utente.setNumeroTelefono(numeroTelefono);
        utente.setEmail(email);
        utente.setPassword(password);

        RequestDispatcher rd = null ;

        UtenteDAO utenteDAO = new UtenteDAO() ;

        //se questa mail è già presente nel db
        if(utenteDAO.doRetrieveByEmail(email) != null)
        {
            request.setAttribute("utente" , utente);
            rd = request.getRequestDispatcher("/WEB-INF/pagine/emailGiaPresente.jsp") ;
            rd.forward(request , response) ;
        }
        else
        {
            utenteDAO.doSave(utente);

            request.setAttribute("utente" , utente);
            rd = request.getRequestDispatcher("/paginaIniziale.jsp") ;
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
