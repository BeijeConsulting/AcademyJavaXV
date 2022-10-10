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
<title>Registration JSP</title>
</head>
<body>


<form action="./register" method="post">
  <label for="email">email:</label><br>
  <input type="text" name="email" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password" value=""><br>
  <label for="nome">nome:</label><br>
  <input type="text" name="nome" value=""><br>
  <label for="cognome">cognome:</label><br>
  <input type="text" name="cognome" value=""><br><br>
  <input type="submit" value="Submit">
 

</form>

</body>
</html>