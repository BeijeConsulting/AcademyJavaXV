<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p style="color: red">${error}</p>
	
	<h1>Modifica Prodotto</h1>
	<form action="./alter_product" method="get">
		<label for="username">Id del prodotto da modificare </label><br> 
		<input type="text" name="id_product" value=""><br> 
		<input type="submit" value="Cerca">
	</form>
	
	
	<form action="./alter_product" method="post">
		<br><br>
		Modifica Prodotto<br>
	  <label for="name">Id:</label><br>
	  <input readonly="text" name="id" value="${product.id}"><br><br>
	  
	  <label for="name">Nome:</label><br>
	  <input type="text" name="name" value="${product.name}"><br><br>
	  
	  <label for="typology">Tipologia:</label><br>
	  <input type="text" name="typology" value="${product.typology}"><br><br>
	  
	  <label for="quantity">Quantita':</label><br>
	  <input type="text" name="quantity" value="${product.quantity}"><br><br>
	  
	  <label for="description">Descrizione</label><br>
	  <input type="text" name="description" value="${product.description}"><br><br>
	  
	  <input type="submit" value="Modifica">
	</form>
	
	<p style="color: green">${alteredProduct} </p> <br>
		${product.name} <br>
		${product.typology} <br>  
		${product.quantity} <br>
		${product.description} <br>
	

</body>
</html>