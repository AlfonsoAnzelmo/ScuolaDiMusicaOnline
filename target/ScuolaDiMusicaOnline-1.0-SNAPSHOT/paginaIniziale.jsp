<%@ page import="model.Utente" %>
<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 01/04/2022
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- il link necessario per l'incona del carrello-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>PaginaIniziale</title>
    </head>

    <body>
    <%

        Utente utente = (Utente)request.getAttribute("utente") ;
        if(utente == null)
        {
    %> <h3>UTENTE NON REGISTRATO</h3>  <%
    }
    else
        {
            String nome = utente.getNome() ;
            %> SALVE <%=nome%><%
        }
    %>

    </body>
</html>
