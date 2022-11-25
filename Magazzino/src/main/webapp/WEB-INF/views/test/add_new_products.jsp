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
	
	
	  <label for="name">Nome:</label><br>
	  <input id="name" type="text" name="name" value=""><br>
	  
	  <label for="typology">Tipologia:</label><br>
	  <input id="typology" type="text" name="typology" value=""><br><br>
	  
	  <label for="quantity">Quantita':</label><br>
	  <input id="quantity" type="number" name="quantity" value=""><br><br>
	  
	  <label for="description">Descrizione</label><br>
	  <input id="description" type="text" name="description" value=""><br><br>
	  
	  <button onclick="register()">Registra</button> 
		
<script>

	function register(){
		
		let name = document.getElementById("name").value;
		let typology = document.getElementById("typology").value;
		let quantity = document.getElementById("quantity").value;
		let description = document.getElementById("description").value;
		
		console.log(name, typology, quantity, description);
		
		fetch('./add_new_product_api', {
			  method: 'POST',
			  body: JSON.stringify({
			    name: name,
			    typology: typology,
			    quantity: quantity,
			    description: description
			  }),
			  headers: {
			    'Content-type': 'application/json; charset=UTF-8',
			  },
			})
			  .then((response) => response.json())
			  .then((json) => console.log(json))
			  .then((check) => alert("Prodotto aggiunto correttamente"))
	}


</script>
</body>
</html>