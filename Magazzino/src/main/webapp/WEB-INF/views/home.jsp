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
	
</body>
</html>