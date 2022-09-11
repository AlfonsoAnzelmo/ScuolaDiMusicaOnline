<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 09/08/2022
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Specifico</title>
    <link rel = "stylesheet" href = "css/MostraProdottiSpecifico.css">

</head>
    <body>
        <div class = "grid-contenitore">
            <c:forEach var="elemento" items="${strumentoMusicaleSpecifico}">
                <%--<b>CODICE STRUMENTO : <c:out value = "${elemento.codiceStrumento}"></c:out></b>
                <b>ID Immagine : <c:out value = "${elemento.getIdImmagine()}"></c:out></b>--%>

                <!--se è l'immagine principale allora aggiungo un campo id-->
                <c:choose>
                    <c:when test="${elemento.principale == true}">
                        <div class = "principale">
                            <img src ="<c:out value = "${elemento.percorsoImmagine}"></c:out>">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class = "immaginiSpecifiche">
                           <img src ="<c:out value = "${elemento.percorsoImmagine}"></c:out>">
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </body>
</html>

