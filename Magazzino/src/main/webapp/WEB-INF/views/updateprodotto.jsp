<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<p>Lista prodotti presenti nel database</p>
${prodotti}

Inserire i campi che si vogliono modificare
<form action="upprodotto" method="post">
	<label for="id">Id prodotto da voler modificare:</label><br>
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