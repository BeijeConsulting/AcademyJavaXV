<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body style="background-color:powderblue;">

<h1>PRODOTTI</h1>
<form action="getprodotti">
	<button>Tutti i prodotti</button>
</form>

<form action="findprodotto">
	<button>ProdottoById</button>
</form>

<form action="insertprodotto">
	<button>Inserisci prodotto</button>
</form>

<form action="updateprodotto">
	<button>Aggiorna prodotto</button>
</form>

<form action="deleteprodotto">
	<button>Elimina prodotto</button>
</form>

<h1>SPEDIZIONI</h1>
<form action="getspedizioni">
	<button>Tutte le spedizioni</button>
</form>

<form action="idspedizione">
	<button>Singola spedizione con contenuto</button>
</form>

<form action="idprodotto">
	<button>Spedizioni per prodotto</button>
</form>



</body>
</html>