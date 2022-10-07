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
String lname = request.getParameter("password");

String errore=request.getParameter("errore");

System.out.print(fname);
System.out.print(lname);
int x = 10+5;
String timestamp = LocalDateTime.now().toString();
%>

<strong><%= timestamp %></strong>
<br>
FIRST NAME : <%= fname %><br>
LAST NAME : <%= lname %><br>

<form action="listaprodotti.jsp">
    <input type="submit" value="Visualizza prodotti" />
</form>

</body>
</html>