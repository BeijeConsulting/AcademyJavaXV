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
		Carrello carrello = new Carrello();
		int count=0;
		%>
		<p>
			Carrello:<%=count%></p>
		<%
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		EntityTransaction transaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT p FROM Product as p");
		List<Product> product = query.getResultList();
		for (Product p : product) {
		%>
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
			<br>
			<br>
		<%}%>

	
	</body>
</html>