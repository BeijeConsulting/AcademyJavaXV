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
		 &nbsp &nbsp  <%= p.getName().toUpperCase()%><br>
		   <%= p.getId()%>&nbsp  
		   <%= p.getDesc()%> <br>
		&nbsp &nbsp <%= p.getPrice() %> Euro &nbsp
		    Quantity: <%= p.getQuantity()%>
		   &nbsp &nbsp Rating: <%= p.getRating()%><br>
		  <% 
		 
	System.out.println(p);
	}
%>

<form action="./CarrelloServlet" method="post">
  <br><label for="id_p">id product</label><br>
  <input type="text" name="id_p" value=""><br>
 

 <input type="submit" value="Submit">
<input type="button" onclick="location.href='carrello.jsp'" value="Carrello"/>
</form>











</body>
</html>