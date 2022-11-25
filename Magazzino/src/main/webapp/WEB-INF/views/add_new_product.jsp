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

	<p style="color: red">${error}</p>
	
	<h1>Aggiungi prodotto al magazzino</h1>
	
	<form action="./add_new_product" method="post">
	  <label for="name">Nome:</label><br>
	  <input type="text" name="name" value=""><br>
	  
	  <label for="typology">Tipologia:</label><br>
	  <input type="text" name="typology" value=""><br><br>
	  
	  <label for="quantity">Quantita':</label><br>
	  <input type="text" name="quantity" value=""><br><br>
	  
	  <label for="description">Descrizione</label><br>
	  <input type="text" name="description" value=""><br><br>
	  
	  <input type="submit" value="Registra">
	</form>
	
	<p style="color: green">${registered} </p> <br>
		${product.name} <br>
		${product.typology} <br>  
		${product.quantity} <br>
		${product.description} <br>
		
<script>

fetch('./add_new_product_api', {
	  method: 'POST',
	  body: JSON.stringify({
	    name:"NuovoProdotto",
	    typology:"Libro",
	    quantity:10,
	    description:"NuovoLibro"
	  }),
	  headers: {
	    'Content-type': 'application/json; charset=UTF-8',
	  },
	})
	  .then((response) => response.json())
	  .then((json) => console.log(json));

</script>
</body>
</html>