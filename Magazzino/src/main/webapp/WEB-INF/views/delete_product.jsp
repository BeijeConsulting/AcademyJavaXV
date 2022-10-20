<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Cancella prodotto</h1>
	
	<p style="color: red">${error}</p>
	<form action="./delete_product" method="get">
		<label for="name">Nome Prodotto </label><br> 
		<input type="text" name="name" value=""><br> 
		<input type="submit" value="Cerca">
	</form>
	
	<br><br>
	<c:forEach items="${products}" var="product">
		<br>- ${product.id}  ${product.name}  ${product.typology}  ${product.quantity}  ${product.description}
	</c:forEach>
	
	<br><br>
	<form action="./delete_product" method="post">
		<label for="id">Inserisci l'id del prodotto da eliminare </label><br> 
		<input type="text" name="id" value=""><br> 
		<input type="submit" value="Elimina">
	</form>
	
	<p style="color: green">${delete}</p>
	
</body>
</html>