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
<div class = "contenitoreFlex">
    <%for(i = 0 ; i < strumentiMusicali.size()  ; i++)
    {%>

            <div>

                <img src = "<%=strumentiMusicali.get(i).getImmaginePrincipalePercorso()%>">
            </div>
            <div class="secDiv">

                     <p id = "modello">Modello
                     <%=strumentiMusicali.get(i).getModello()%></p>

                        <p id = "prezzo"> Prezzo
                        <%=strumentiMusicali.get(i).getPrezzo()%></p>

                        <p><a href = "RimuoviProdottoCarrello">Rimuovi dal Carrello</a></p>
                        <p><a href = "AggiungiAiPreferitiCarrello">AggiungiAiPreferiti</a></p>

                       <p>Quantita
                        <select value = "quantita" id = "quantita">
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
                        </select>  </p>
                       <a id = "acquista" href ="Acquista">Acquista</a>
            </div>


    <%}%>
</div>
<!-- eh ! qui l'unica è calcolarsi con js quanto è grande contenitoreFlex per uscirne
        perchè il flex finisce sopra il footer e bisogna spostarlo piu in basso
        man mano gl'oggetti del carrello aumentano-->
<% //@include file="footer.html"%>
</body>
</html>
