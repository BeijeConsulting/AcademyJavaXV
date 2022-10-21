<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>BENVENUTO NEL NOSTRO MAGAZZINO</h1>
	
	<form action="./all_products" method="get">
		<input type="submit" value="Lista di tutti i prodotti">
	</form>
	
		<form action="./show_description" method="get">
		<input type="submit" value="Cerca descrizione tramite id">
	</form>
	
	<form action="./add_new_product" method="get">
		<input type="submit" value="Crea nuovo prodotto">
	</form>
	
	<form action="./alter_product" method="get">
		<input type="submit" value="Modifica prodotto">
	</form>

	<form action="./delete_product" method="get">
		<input type="submit" value="Cancella Prodotto">
	</form>
	
	<form action="./list_product_by_typology" method="get">
		<input type="submit" value="Lista prodotti by tipologia">
	</form>
	
	<form action="./list_product_by_name_description" method="get">
		<input type="submit" value="Lista prodotti by nome o/e descrizione">
	</form>

	<form action="./all_shipment" method="get">
		<input type="submit" value="Lista spedizioni">
	</form>

</body>
</html>