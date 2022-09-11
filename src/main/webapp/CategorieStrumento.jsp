<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <title>Categorie</title>
    <link rel = "stylesheet" href="css/categoriaStrumento.css">
</head>
<body>
    <%@include file="paginaIniziale.jsp"%>

    <div class = "contenitoreCategorie" style="margin-left:12%; margin-right: 12%">

         <c:forEach var = "elemento" items = "${CategorieStrumento}">
            <div>
                <a href="MostraProdotti?categoriaId=<c:out value = "${elemento.id}"></c:out>">
                <div>
                    <c:out value = "${elemento.nome}"></c:out>
                </div>
                <div>

                        <img src = "<c:out value = "${elemento.percorso}"></c:out>" height="150px" width="150px">

                </div>
                </a>
            </div>
        </c:forEach>
    </div>
<%--
    <%
      ArrayList<CategorieStrumentoBean> categories = (ArrayList<CategorieStrumentoBean>) request.getAttribute("CategorieStrumento") ;
      int i ;
      for(i = 0 ; i < categories.size() ; i++)
      {%>
        <div class = "contenitoreCategorie" style="margin-left:12%; margin-right: 12%">
            <b><%=categories.get(i).getNome()%></b>
            <a href="MostraProdotti?categoriaId=<%=categories.get(i).getId()%>">
                <img src = "<%=categories.get(i).getPercorso()%>" height="150px" width="150px">
            </a>
        <% } %>
        </div>
--%>
    <div style="margin-top:100px"></div>
<%@include file="footer.html"%>
</body>
</html>
