<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Registrazione</h1>

<form action="../RegisterUser" method="post">
		<label for="username">Nome</label><br> 
		<input type="text" name="name" value=""><br> 
		
		<label for="password">Cognome</label><br>
		<input type="text" name="surname" value=""><br> 
		
		<label for="password">Email</label><br>
		<input type="text" name="surname" value=""><br> 
		
		<label for="password">Password</label><br>
		<input type="password" name="surname" value=""><br> 
		
		<br><input type="submit" value="Register">
	</form>

</body>
</html>