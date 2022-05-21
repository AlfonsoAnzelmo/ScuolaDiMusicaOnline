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
    <title>MostraProdotto</title>
</head>
<body>
    <%
        ArrayList<StrumentiMusicali> musicali = (ArrayList<StrumentiMusicali>) request.getAttribute("musicali");
        int i ;
        for(i = 0 ; i < musicali.size() ; i++)
        {%>
            <%= musicali.get(i).getNome() %> -
            <%=musicali.get(i).getModello()%>
        <%}
    %>


</body>
</html>
