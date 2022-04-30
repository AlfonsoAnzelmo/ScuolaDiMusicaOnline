<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.Categorie" %>
<%@ page import="model.CategorieEprodotti.CategorieBean" %><%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 30/04/2022
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categorie</title>
</head>
<body>
    <%
      ArrayList<CategorieBean> categories = (ArrayList<CategorieBean>) request.getAttribute("categorie") ;
      int i ;
      for(i = 0 ; i < categories.size() ; i++)
      {%>
    <b><%=categories.get(i).getNome()%></b>
    <img src = "downloadImageCategoria?id=<%=categories.get(i).getId()%>" height="150px" width="150px">
      <%}
    %>

</body>
</html>
