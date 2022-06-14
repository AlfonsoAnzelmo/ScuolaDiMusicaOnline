<%@ page import="controller.Carrello" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Carrello.CarrelloBean" %>
<%@ page import="model.StrumentiMusicali.StrumentiMusicali" %>
<%@ page import="model.Corso.Corso" %>
<%@ page import="model.Utente" %><%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 13/06/2022
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>
    <link rel = "stylesheet" href="css\Carrello.css">
</head>
<body>
<%@include file="paginaIniziale.jsp"%>

<%
    CarrelloBean carrelli = (CarrelloBean) request.getAttribute("carrelli");
    int i ;
    ArrayList<StrumentiMusicali> strumentiMusicali = carrelli.getStrumentiMusicali() ;
    ArrayList<Corso> corsi = carrelli.getCorsi() ;
    Utente utente = carrelli.getUtente() ;
    %>
    <span id="messaggioSaluto">ciao <%=utente.getNome()%> Questo è il tuo carrello</span>

    <%for(i = 0 ; i < strumentiMusicali.size()  ; i++)
    {%>
        <div class = "contenitoreFlex">
            <div>

                <img src = "<%=strumentiMusicali.get(i).getImmaginePrincipalePercorso()%>">
            </div>
            <div>

                    Modello
                        <%=strumentiMusicali.get(i).getModello()%>

                    Prezzo
                        <%=strumentiMusicali.get(i).getPrezzo()%>

                        <a href = "RimuoviProdottoCarrello">rimuovi</a>
                        <a href = "AggiungiAiPreferitiCarrello">AggiungiAiPreferiti</a>

                        Quantita
                        <select>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>8</option>
                            <option>10+</option>
                        </select>

            </div>
        </div>
    <%}%>

    <%@include file="footer.html"%>
</body>
</html>
