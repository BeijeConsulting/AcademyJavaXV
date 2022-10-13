<%@page import="java.util.*"%>
<%@page import="it.beije.hopper.ecommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<div id="header">
		<h1>Benvenuti nel nostro ecommerce</h1>
	</div>

	<div id="nav" align = "right">
		<form action="../loginEcommerce" method="post">
			<input type="submit" value="Login">
		</form>

		<form action="../registerEcommerce" method="post">
			<input type="submit" value="Register">
		</form>
	</div>

	<div id="sidebar1">
		<!-- contenuto sidebar 1 -->
	</div>

	<div id="main">
		<c:forEach items="${products}" var="product">

			<br>
			<b>${product.name}</b>
			<br>${product.desc}
			<br>Costo: ${product.price} euro
			<br>
			<form action="./ecommerce" method="get">
			<input type="number" id="quantity" name="quantity" min="1" max= "${product.quantity}">
			<button name="button" type="submit" value="${product.id}">Aggiungi</button>
		</form>
			
			<br>
		</c:forEach>
	</div>

	<div id="sidebar2">
		Lista Carrello
	</div>



</body>
</html>