package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StrumentoMusicaleSpecifico.StrumentoMusicaleSpecifico;
import model.StrumentoMusicaleSpecifico.StrumentoMusicaleSpecificoDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MostraProdottoSpecifico", value = "/MostraProdottoSpecifico")
public class MostraProdottoSpecifico extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //qui insersci
        int codice = Integer.parseInt(request.getParameter("codice")) ;
        if(codice != 0)
        {
            StrumentoMusicaleSpecificoDAO d = new StrumentoMusicaleSpecificoDAO() ;
            ArrayList<StrumentoMusicaleSpecifico> sms = d.doRetrieveByCodice(codice) ;

            request.setAttribute("strumentoMusicaleSpecifico" , sms) ;

            RequestDispatcher rd = request.getRequestDispatcher("MostraProdottoSpecifico.jsp") ;
            rd.forward(request , response) ;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}

