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

	<h1>Cerca descrizione prodotto</h1>
	
	<br>
	Lista prodotti
	<c:forEach items="${products}" var="product">
		<br>- id: ${product.id} => ${product.name}
	</c:forEach>
	
	
	<br><br>
	<p style="color: red">${error}</p>
	<form action="./show_description" method="get">
		<label for="username">Id Product </label><br> 
		<input type="text" name="id_product" value=""><br> 
		<input type="submit" value="Cerca">
	</form>
	
	<br>
	Descrizione
		<br>- ${product.name} 
		<br>&nbsp &nbsp ${product.typology} 
		<br>&nbsp &nbsp ${product.description} 
	

</body>
</html>