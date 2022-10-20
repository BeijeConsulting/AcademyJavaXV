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
	
	<h1>Cerca prodotto</h1>

	<br><br>
		<p style="color: red">${error}</p>
		<form action="./list_product_by_name_description" method="get">
			<label for="name">Nome</label><br> 
			<input type="text" name="name" value=""><br><br> 
			
			<label for="description">Descrizione</label><br> 
			<input type="text" name="description" value=""><br> 
			<input type="submit" value="Cerca">
		</form>
		
		<br>
			
		<c:forEach items="${products}" var="product">
		<br>- ${product}
		</c:forEach>

</body>
</html>