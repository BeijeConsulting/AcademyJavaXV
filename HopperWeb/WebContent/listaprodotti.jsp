<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
		
		if(purchase!=null)
			if(purchase.equals("acquisto")){%>
			<p style=color:green>Ordine effettuato</p>
		<%}%>
		
		<form action="purchase.jsp">
		<button type="submit">Purchase products</button>
		</form>
		
		<p>
			Carrello:<%= cart.size()%></p>
		<%
			
			List<Product> products=(List<Product>)session.getAttribute("prod");
			if(!(products==null)){
				for (int i=0;i<products.size();i++) {
		%>
		
					<p>
						Name:
						<%=products.get(i).getName()%></p>
					<p>
						Price: &euro;<%=products.get(i).getPrice()%></p>
					<p>
						Quantity:
						<%=products.get(i).getQuantity()%></p>
					<p>
						Rating:
						<%=products.get(i).getRating()%></p>
					<p>
						Description:
						<%=products.get(i).getDesc()%></p>
						<form action="listaprodotti.jsp">
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