<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p style="color: red">${errore}</p>

<h1>Registrazione nuovo utente</h1>

<form action="./register" method="post">
  <label for="name">Nome:</label><br>
  <input type="text" name="name" value=""><br>
  
  <label for="surname">Cognome:</label><br>
  <input type="text" name="surname" value=""><br><br>
  
  <label for="email">Email:</label><br>
  <input type="text" name="email" value=""><br><br>
  
  <label for="password">Password:</label><br>
  <input type="text" name="password" value=""><br><br>
  
  <input type="submit" value="Submit">
</form>

</body>
</html>