<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alter Product</title>
</head>
<body>

	<p style="color: red">${error}</p>
	
	<h1>Modifica Prodotto</h1>
	
	<label for="username">Id del prodotto da modificare</label><br> 
	<input type="text" name="id_product" id="id_product"><br> 
	<button onclick="searchById()">Cerca</button>  
	
	
	<div id="showDescription"></div>
	
	<br><br>
	Modifica Prodotto<br>
	<label for="name">Id:</label><br>
	<input type="text" name="id" value="" id="id"><br><br>
	  
	<label for="name">Nome:</label><br>
	<input type="text" name="name" id="name" value=""><br><br>
	  
	<label for="typology">Tipologia:</label><br>
	<input type="text" name="typology" id="typology" value=""><br><br>
	  
	<label for="quantity">Quantita':</label><br>
	<input type="number" name="quantity" id="quantity" value=""><br><br>
	  
	<label for="description">Descrizione</label><br>
	<input type="text" name="description" id="description" value=""><br><br>
	  
	<button onclick="updateProduct()">Modifica</button>  
	
	
	<p style="color: green">${alteredProduct} </p> <br>
		${product.name} <br>
		${product.typology} <br>  
		${product.quantity} <br>
		${product.description} <br>

	
<script>


	function searchById(){
		let id =  document.getElementById("id_product").value;
		let product;
		fetch("./show_description_apiT/" + id.toString())
    	.then(response => response.json())
    	.then(json => product = json)
		.then((show) => setProduct(product))
	}
	
	function setProduct(product){
		console.log(product.name)
		document.getElementById('id').value = product.id
		document.getElementById('name').value = product.name
		document.getElementById('typology').value = product.typology
		document.getElementById('quantity').value = product.quantity
		document.getElementById('description').value = product.description 
	}
	
	function updateProduct(){
		let id = document.getElementById("id").value;
		let name = document.getElementById("name").value;
		let typology = document.getElementById("typology").value;
		let quantity = document.getElementById("quantity").value;
		let description = document.getElementById("description").value;
		
		fetch('./alter_product_api', {
			  method: 'POST',
			  body: JSON.stringify({
				id:id,
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
			.then((check) => alert("Prodotto modificato correttamente"))
	}
	
</script>
</body>
</html>