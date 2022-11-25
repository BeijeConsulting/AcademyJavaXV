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

<form action="./tipologiaprodotto" method="post">
  <label for="tipologia">tipologia:</label><br>
  <input type="text" name="tipologia" value=""><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>