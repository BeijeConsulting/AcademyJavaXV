<%@page import="it.beije.hopper.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>

<jsp:useBean id="loggedUser" class="it.beije.hopper.web.User" scope="session"></jsp:useBean>
<%
/* jsp:useBean EQUIVALE A
User loggedUser = (User) session.getAttribute("loggedUser");
if (loggedUser == null) {
	loggedUser = new User();
	session.setAttribute("loggedUser", loggedUser);
}*/
%>

<%
//String fname = (String) session.getAttribute("fname");
//String lname = (String) session.getAttribute("lname");

System.out.println("loggedUser : " + loggedUser);
%>

<br>
QUESTE LE TUE CREDENZIALI<br><br>
FIRST NAME : <%= loggedUser.getFirstName() %><br>
LAST NAME : <%= loggedUser.getLastName() %>

</body>
</html>