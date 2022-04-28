<%@ page import="model.Utente" %><%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 02/04/2022
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gia presente</title>
</head>
<body>
<h1>EMAIL GIA PRESENTE</h1>
<% Utente utente = (Utente)request.getAttribute("utente") ;%>
<%=utente.getEmail()%>
</body>
</html>
