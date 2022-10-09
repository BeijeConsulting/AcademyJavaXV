<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<%
String fname = request.getParameter("email");
String password = request.getParameter("password");

%>


FIRST NAME : <%= fname %><br>
Password : <%= password %><br>
<br>

<form action="listaprodotti.jsp">
    <input type="submit" value="Visualizza prodotti nello store" />
</form>

</body>
</html>