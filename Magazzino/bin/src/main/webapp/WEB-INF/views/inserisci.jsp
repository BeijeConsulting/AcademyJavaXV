<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP</title>
</head>
<body>

<p style="color: red">${errore}</p>

<form action="./nuovoprodotto" method="post">
  <label for="nome">nome:</label><br>
  <input type="text" name="nome" value=""><br>
    <label for="tipologia">tipologia:</label><br>
  <input type="text" name="tipologia" value=""><br>
    <label for="quantita">quantita:</label><br>
  <input type="text" name="quantita" value=""><br>
    <label for="descrizione">descrizione:</label><br>
  <input type="text" name="descrizione" value=""><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>