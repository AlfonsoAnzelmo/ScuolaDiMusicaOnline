
<%@ page import="java.util.ArrayList"%>
<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 02/04/2022
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>catalogo</title>
</head>
<body>
<h1>catalogo</h1>
<%

    ArrayList<String> listaCategorie = (ArrayList<String>) request.getAttribute("listaCategorie");
    int i ;
    for(i = 0 ; i < listaCategorie.size() ; i++)
    {
        %>
        <%= listaCategorie.get(i)%>
   <% }%>
</body>
</html>
