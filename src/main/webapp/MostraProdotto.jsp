<%@ page import="java.util.ArrayList" %>
<%@ page import="model.StrumentiMusicali.StrumentiMusicali" %><%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 12/05/2022
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel = "stylesheet" href="css/MostraProdotti.css">
    <title>MostraProdotto</title>
</head>
<body>
<%@include file="paginaIniziale.jsp"%>

    <div class ="contenitoreLista">
       <div class = "contenitoreFiltro" >
           tymtsdcsdvj oidsb vosbvjosbvbsbusbvuisbvbodsbvs
       </div>
    <%
        ArrayList<StrumentiMusicali> musicali = (ArrayList<StrumentiMusicali>) request.getAttribute("musicali");
        int i ;
        for(i = 0 ; i < musicali.size() ; i++)
        {%>
        <div class = "contenitore-strumentoMusicale">
            <div class = strumentoMusicale>
                <img src = "<%=musicali.get(i).getImmaginePrincipalePercorso()%>">
                <label id="modello"><%=musicali.get(i).getModello()%>
                    <br><br><br><br><br><br>
                    <%=musicali.get(i).getPrezzo()%>
                </label>
            <label> qui ci vuole lo shopping cart <br>magari anche la stellina per i desideri</label>
            </div>

        </div>
        <%}
    %>

    </div>
    <%@include file="footer.html"%>
</body>
</html>
