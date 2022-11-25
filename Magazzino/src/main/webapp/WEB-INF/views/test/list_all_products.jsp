<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Prodotti</title>
</head>
<body>
	
	<h1>Lista dei prodotti presenti in magazzino</h1>
	
	 <button onclick="loadProduct()">Prodotti</button>    
	
	<div id="showProduct">
	</div>

<script>

	function loadProduct(){
		let products;
		
		fetch('./all_products_apiT')
			.then((response) => response.json())
		  	.then((json) =>products = json)
			.then((show) => showProduct(products))
	}
	
	function showProduct(products){
		
		let count = 1;
		
		let stampa = "<table>"
		stampa += "<tr> <td></td> <td>NAME</td> <td>TYPOLOGY</td> <td>QUANTITY</td>  <td>DESCRIPTION</td> </tr>"
		
		products.forEach(el => {
			stampa += "<tr> <td>" + count + "</td> <td>"+el.name+"</td> <td>"
			          +el.typology+"</td> <td>"+el.quantity+"</td>  <td>"+el.description+"</td> </tr>";
			count++;
		});
		
		stampa += "</table>";
		
		document.getElementById('showProduct').innerHTML = stampa
	}


</script>

</body>
</html>