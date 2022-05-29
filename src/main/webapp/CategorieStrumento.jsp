<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.CategorieStrumento" %>
<%@ page import="model.CategorieStrumento.CategorieStrumentoBean" %><%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 30/04/2022
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categorie</title>
    <link rel = "stylesheet" href="css/categorieStrumento.css">
</head>
<body>
    <%@include file="paginaIniziale.jsp"%>

    <%
      ArrayList<CategorieStrumentoBean> categories = (ArrayList<CategorieStrumentoBean>) request.getAttribute("CategorieStrumento") ;
      int i ;
      for(i = 0 ; i < categories.size() ; i++)
      {%>
    <div class = "contenitoreCategorie">

<b><%=categories.get(i).getNome()%></b>
<a href="MostraProdotti?categoriaId=<%=categories.get(i).getId()%>">
    <img src = "<%=categories.get(i).getPercorso()%>" height="150px" width="150px">
</a>
  <% } %>
</div>
<div style="margin-top:100px">

</div>
<%@include file="footer.html"%>
</body>
</html>
