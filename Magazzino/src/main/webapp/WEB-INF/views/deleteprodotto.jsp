<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<body style="background-color:powderblue;">

<p>Lista prodotti presenti nel database</p>
<c:forEach items="${prodotti}" var="p">
	<br><strong>Id:</strong>${p.id}<strong>Nome:</strong>${p.nome} <strong>TIPOLOGIA:</strong>${p.tipologia} 
	<strong>QUANTITA':</strong>${p.quantita} <strong>DESCRIZIONE:</strong>${p.descrizione}
</c:forEach>

<br><br>
<form action="delprodotto" method="post">
	<label for="id">Id prodotto da voler eliminare:</label><br>
  	<input type="text" name="id" value=""><br>
  	<input type="submit" value="Submit">
</form>

<form action="back">
	<button>Torna alla home</button>
</form>

</body>
</html>