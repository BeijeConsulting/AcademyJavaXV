<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.Query"%>
<%@page import="it.beije.hopper.web.ecommerce.p.JPAEntityManagerFactory"%>
<%@page import="it.beije.hopper.web.ecommerce.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP</title>
</head>
<body>
LOGIN
<p style="color: red">
<%
String error = (String) session.getAttribute("errore");
if (error != null) {
	out.print(error);
	session.removeAttribute("errore");
}
%>
</p>

<form action="./logine" method="post">
  <label for="username">Username:</label><br>
  <input type="text" name="username" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password" value=""><br><br>
  <input type="submit" value="Login">
 <input type="button" onclick="location.href='registration.jsp'" value="registration"/>

</form>

</body>
</html>