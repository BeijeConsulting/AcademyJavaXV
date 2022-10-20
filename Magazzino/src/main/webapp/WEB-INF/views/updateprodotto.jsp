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

<p>Lista prodotti presenti nel database</p>
<c:forEach items="${prodotti}" var="p">
	<br><strong>Id:</strong>${p.id}<strong>Nome:</strong>${p.nome} <strong>TIPOLOGIA:</strong>${p.tipologia} 
	<strong>QUANTITA':</strong>${p.quantita} <strong>DESCRIZIONE:</strong>${p.descrizione}
</c:forEach>

<br><br>Inserire i campi che si vogliono modificare
<br><br><form action="upprodotto" method="post">
	<label for="id">Id prodotto:</label><br>
  <input type="text" name="id" value=""><br>
  <label for="nome">Nome prodotto:</label><br>
  <input type="text" name="nome" value=""><br>
  <label for="tipologia">Tipologia prodotto:</label><br>
  <input type="text" name="tipologia" value=""><br>
  <label for="quantita">Quantità prodotto:</label><br>
  <input type="text" name="quantita" value=""><br>
  <label for="descrizione">Descrizione prodotto:</label><br>
  <input type="text" name="descrizione" value=""><br><br>
  <input type="submit" value="Submit">
</form>


</body>
</html>