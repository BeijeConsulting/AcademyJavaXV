<%@page import="java.util.*"%>
<%@page import="it.beije.hopper.web.ecommerce.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Benvenuti nel nostro ecommerce</h1>



<%
	List<Product> products = ProductConnections.getAllProducts();
	for(Product p : products){
		out.print(p.toString() );
		%> <br> <% 
	}
%>

<form action="../loginEcommerce" method="post">
  <input type="submit" value="Login">
</form>

<form action="../registerEcommerce" method="post">
  <input type="submit" value="Register">
</form>

</body>
</html>