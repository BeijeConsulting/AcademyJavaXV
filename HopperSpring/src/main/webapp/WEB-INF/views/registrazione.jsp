<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE UTENTE</title>
</head>
<body>

<p style="color: red">${errore}</p>

<form action="./user" method="post">
  <label for="email">EMAIL:</label><br>
  <input type="text" name="email" value=""><br>
  <label for="password">PASSWORD:</label><br>
  <input type="password" name="password" value=""><br><br>
  <label for="firstName">FIRST NAME:</label><br>
  <input type="text" name="firstName" value=""><br><br>
  <label for="lastName">LAST NAME:</label><br>
  <input type="text" name="lastName" value=""><br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>