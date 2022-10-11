<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 10/10/2022
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    String benvenuto = "Complimenti "+ fname +"! Hai effettuato l'accesso";
%>
<html>
<head>
    <title>Benvenuto Utente!!!</title>
</head>
<body>
<div>
    <strong><%= benvenuto %></strong><br>
    FIRST NAME : <%= fname %><br>
    LAST NAME : <%= lname %><br>
</div>
</body>
</html>
