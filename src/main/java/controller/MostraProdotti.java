package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StrumentiMusicali.StrumentiMusicali;
import model.StrumentiMusicali.StrumentiMusicaliDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MostraProdotti", value = "/MostraProdotti")
public class MostraProdotti extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int categoriaId = Integer.parseInt(request.getParameter("categoriaId")) ;

        StrumentiMusicaliDAO musicaliDAO = new StrumentiMusicaliDAO() ;
        ArrayList<StrumentiMusicali> musicali = musicaliDAO.doRetrieveByCategoriaId(categoriaId) ;

        request.setAttribute("musicali" , musicali);

        RequestDispatcher rd = request.getRequestDispatcher("MostraProdotto.jsp") ;
        rd.forward(request , response) ;
    }
}
