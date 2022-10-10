<%@page import="it.beije.hopper.web.ecommerce.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>
PRODOTTI DISPONIBILI<br><br>

<%

List<Product> ris = (List<Product>)session.getAttribute("prod");

	for (Product p: ris){
		%>
		<br>
		   <%= p %>
		  <% 
		 
	System.out.println(p);
	}
%>
<form action="./logine" method="post">
  <label for="id_p">id_p:</label><br>
  <input type="text" name="id_p" value=""><br>
 
  <input type="submit" value="Submit">
 <input type="button" onclick="location.href='Carrello.jsp'" value="carrello"/>

</form>











</body>
</html>