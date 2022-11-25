<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancella utente</title>
</head>
<body>

	<h1>Cancella prodotto</h1>
	
	
	
	<label for="name">Nome Prodotto </label><br> 
	<input type="text" name="name" value="" id="nameProduct"><br> 
	<button onClick="searchById()">Cerca</button>
	
	
	<br><br>
	<div id="showProducts"></div>
	
	<br><br>
	
	<label for="id">Inserisci l'id del prodotto da eliminare </label><br> 
	<input type="number" name="id" value="" id="id"><br> 
	<button onClick="deleteProduct()">Elimina</button>

<script>

	function searchById(){
		let name =  document.getElementById("nameProduct").value;
		let product;
		fetch("./search_by_name?name="+name)
		.then(response => response.json())
		.then(json => product = json)
		.then((show) => showProduct(product))
	}
	
	function showProduct(products){
			
			let stampa = "<table>"
			stampa += "<tr> <td></td> <td>NAME</td> <td>TYPOLOGY</td> <td>QUANTITY</td>  <td>DESCRIPTION</td> </tr>"
			
			products.forEach(el => {
				stampa += "<tr> <td>" + el.id + "</td> <td>"+el.name+"</td> <td>"
					    +el.typology+"</td> <td>"+el.quantity+"</td>  <td>"+el.description+"</td> </tr>";
				});
			stampa += "</table>";
			document.getElementById('showProducts').innerHTML = stampa
		}
	
	function deleteProduct(){
		let id =  document.getElementById("id").value;
		
		fetch('./delete_product_api/'+id.toString(), {
			  method: 'POST',
			  body: JSON.stringify(),
			  headers: {
			    'Content-type': 'application/json; charset=UTF-8',
			  },
		})
		.then((response) => response.json())
		.then((json) => console.log(json))
		.then((check) => alert("Prodotto eliminato correttamente"))
		
	}

</script>
	
</body>
</html>