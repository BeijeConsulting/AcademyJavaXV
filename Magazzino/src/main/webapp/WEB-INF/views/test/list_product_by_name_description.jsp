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
		
		
	<label for="name">Nome</label><br> 
	<input id="name" type="text" name="name" value=""><br><br> 
			
	<label for="description">Descrizione</label><br> 
	<input id="description" type="text" name="description" value=""><br> 
	<button onClick="findByTypology()">Cerca</button>
		
	<br><br>
	
	<div id="listProducts"></div>
			
<script>
	function findByTypology(){
		let name = document.getElementById("name").value;
		let description = document.getElementById("description").value;
		
		fetch("./list_product_by_typology_api?name="+name+"&description="+description)
		.then(response => response.json())
		.then(json => products = json)
		.then(show => showProduct(products))
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
		
		document.getElementById('listProducts').innerHTML = stampa
		}
</script>

</body>
</html>