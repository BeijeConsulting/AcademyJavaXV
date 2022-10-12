<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.hopper.ecommerceweb.Carrello"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Carrello cart=(Carrello)session.getAttribute("cart");
for(int i=0;i<cart.size();i++){%>
<p><%= cart.getProduct(i).getName() %> </p>
<p>&euro;<%= cart.getProduct(i).getPrice() %> </p>
<p><%= cart.getProduct(i).getQuantity() %> </p>
<p><%= cart.getProduct(i).getRating() %> </p>
<p><%= cart.getProduct(i).getDesc() %></p>

<%} %>
<form action=PurchaseServlet>
<button>Purchase</button>
</form>
</body>
</html>