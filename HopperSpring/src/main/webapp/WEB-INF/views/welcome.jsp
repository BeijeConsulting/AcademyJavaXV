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
/*
User loggedUser = (User) session.getAttribute("loggedUser");

System.out.println(loggedUser.getFirstName());
System.out.println(loggedUser.getLastName());
int x = 10+5;
*/
%>

<br>
FIRST NAME : ${loggedUser.firstName}<br>
LAST NAME : ${loggedUser.lastName}<br>
GENDER : ${loggedUser.gender}

<form action="login.jsp" method="POST">
<button></button></form>

</body>
</html>