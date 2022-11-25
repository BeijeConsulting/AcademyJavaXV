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
	
	<h1>Lista dei prodotti presenti in magazzino</h1>
	
	<p style="color: red">${error}</p>
	<!--  
	<c:forEach items="${products}" var="product">
		<br>- ${product.name}  ${product.typology}  ${product.quantity}
</c:forEach>
-->

<script>


fetch('./all_products_api')
	  .then((response) => response.json())
	  .then((json) => console.log(json));

</script>

</body>
</html>