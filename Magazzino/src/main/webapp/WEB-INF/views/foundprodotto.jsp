<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotto By Id</title>
</head>
<body>
<body style="background-color:powderblue;">
<h1>Prodotto By Id</h1>

<br><strong>Nome:</strong>${prodotto.nome} <strong>TIPOLOGIA:</strong>${prodotto.tipologia} 
	<strong>QUANTITA':</strong>${prodotto.quantita} <strong>DESCRIZIONE:</strong>${prodotto.descrizione}

<form action="back">
	<button>Torna alla home</button>
</form>
</body>
</html>