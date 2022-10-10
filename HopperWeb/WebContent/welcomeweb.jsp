
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
//String fname = request.getParameter("email");
//String password = request.getParameter("password");

String email=(String)session.getAttribute("email");
String password=(String)session.getAttribute("password");
%>


FIRST NAME : <%= email %><br>
Password : <%= password %><br>
<br>

<form action="listaprodotti.jsp">
    <input type="submit" value="Visualizza prodotti nello store" />
</form>

</body>
</html>