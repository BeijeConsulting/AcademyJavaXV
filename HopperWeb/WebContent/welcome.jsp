<%@page import="it.beije.hopper.web.User"%>
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
//String fname = request.getParameter("fname");
//String lname = request.getParameter("lname");

//String fname = (String) session.getAttribute("fname");
//String lname = (String) session.getAttribute("lname");

User loggedUser = (User) session.getAttribute("loggedUser");

System.out.println(loggedUser.getFirstName());
System.out.println(loggedUser.getLastName());
int x = 10+5;
String timestamp = LocalDateTime.now().toString();
%>

<strong><%= timestamp %></strong>
<br>
FIRST NAME : <%= loggedUser.getFirstName() %><br>
LAST NAME : <%= loggedUser.getLastName() %>

</body>
</html>