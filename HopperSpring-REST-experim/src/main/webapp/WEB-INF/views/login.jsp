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

<form action="./login" method="POST">
  <label for="username">Username:</label><br>
  <input type="text" name="username" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password" value=""><br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>