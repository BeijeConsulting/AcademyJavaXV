<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<body style="background-color:grey;">

<h1>PRODOTTI</h1>
<form action="prodotti">
	<button>Tutti i prodotti</button>
</form>

<form action="findprodotto">
	<button>ProdottoById</button>
</form>

<form action="in">
	<button>Inserisci prodotto</button>
</form>

<form action="updateprodotto">
	<button>Aggiorna prodotto</button>
</form>

<form action="deleteprodotto">
	<button>Elimina prodotto</button>
</form>


</body>
</html>