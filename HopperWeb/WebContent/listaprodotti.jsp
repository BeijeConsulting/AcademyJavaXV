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
	
	<jsp:useBean id="loggedUser" class="it.beije.hopper.entity.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="email" name="loggedUser" param="email"/>
	<jsp:setProperty property="password" name="loggedUser" param="password"/>
	
		<h1 style="color: red">LISTA PRODOTTI</h1>
		<%
		String purchase=(String) session.getAttribute("acquisto");
		Carrello cart=(Carrello)session.getAttribute("cart");
		Product prod=(Product)session.getAttribute("p");
		
		if(purchase!=null)
			if(purchase.equals("acquisto")){%>
			<p style=color:green>Acquisto effettuato</p>
		<%}%>
		
		<form action="purchase.jsp">
		<button type="submit">Purchase products</button>
		</form>
		
		<p>
			Carrello:<%= cart.size()%></p>
		<%
			
			List<Product> products=(List<Product>)session.getAttribute("prod");
			if(!(products==null)){
				for (Product p : products) {
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
						<form action="AddcartServlet">
						<%
							prod=p;
						%>
						<button type="submit">Add to cart</button>
						</form>
					<br>
			
					<br>
				<%}
			}else{
				if(loggedUser.getEmail()==null || loggedUser.getPassword()==null)
				response.sendRedirect("loguser.jsp");
			}%>	
	</body>
</html>