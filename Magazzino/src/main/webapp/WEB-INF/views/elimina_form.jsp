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

<form action="./eliminaprodotto" method="post">
<label for="id">id:</label><br>
  <input type="text" name="id" value=""><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>