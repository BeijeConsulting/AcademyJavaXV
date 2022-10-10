<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="it.beije.hopper.ecommerceweb.JPAEntityManagerFactory"%>
<%@page import="it.beije.hopper.entity.Product"%>
<%@page import="it.beije.hopper.ecommerceweb.Carrello"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.persistence.Query"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista prodotti</title>
	</head>
	<body>
		<h1 style="color: red">LISTA PRODOTTI</h1>
		
		<%
		Carrello carrello=new Carrello();
		%>
		<p>
			Carrello:<%= carrello.size()%></p>
		<%
		List<Product> product=(List<Product>)session.getAttribute("prod");
		for (Product p : product) {
		%>
		<form method="POST" action="ProdServlet">
			<p>
				Name:
				<%=p.getName()%></p>
			<p>
				Price: &euro;<%=p.getPrice()%></p>
			<p>
				Quantity:
				<%=p.getQuantity()%></p>
			<p>
				Rating:
				<%=p.getRating()%></p>
			<p>
				Description:
				<%=p.getDesc()%></p>
				<button type="submit">Add to cart</button>
			<br>
			
			<br>
		<%}%>
		</form>
	</body>
</html>