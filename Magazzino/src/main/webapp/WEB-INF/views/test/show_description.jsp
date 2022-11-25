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
	<div id="listProduct"></div>
	<button onclick="loadListProduct()">Prodotti</button>
	
	
	<br><br>

	<label for="username">Id Product </label><br> 
	 <input id = "id" type="number" name="id" value="1"><br>
	<button onclick="searchById()">Cerca</button> 
	
	
	<br><br>
	<div id="showDescription"></div>
	

<script>
	function loadListProduct(){
		let products;
		console.log("Ciao");
		fetch('./all_products_apiT')
			.then((response) => response.json())
		  	.then((json) =>products = json)
			.then((show) => showListProduct(products))
	}
	
	function showListProduct(products){
		
		let stampa = "<table>"
		stampa += "<tr> <td>ID</td> <td>NAME</td> </tr>"
		
		products.forEach(el => {
			stampa += "<tr> <td>" + el.id + "</td> <td>"+el.name+"</td> </tr>";
		});
		
		stampa += "</table>";
		
		document.getElementById('listProduct').innerHTML = stampa
	}
	
	function searchById(){
		let id =  document.getElementById("id").value;
		let product;
		console.log(id);
		fetch("./show_description_apiT/" + id.toString())
    	.then(response => response.json())
    	.then(json => product = json)
		.then((show) => showProduct(product))
	}
	
	function showProduct(product){
		let stampa = "<table>"
		stampa += "<tr><td>NAME</td> <td>TYPOLOGY</td> <td>QUANTITY</td>  <td>DESCRIPTION</td> </tr>"
		stampa += "<tr><td>"+product.name+"</td> <td>"
	          +product.typology+"</td> <td>"+product.quantity+"</td>  <td>"+product.description+"</td> </tr>";
		stampa += "</table>";
		
		document.getElementById('showDescription').innerHTML = stampa
	}
	
</script>

</body>
</html>