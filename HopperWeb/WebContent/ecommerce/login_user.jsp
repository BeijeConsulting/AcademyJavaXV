<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="../loginEcommerce" method="post">
		<label for="username">Username:</label><br> <input type="text"
			name="username" value=""><br> <label for="password">Password:</label><br>
		<input type="password" name="password" value=""><br> <input
			type="submit" value="Login">
	</form>

	<form action="../registerEcommerce" method="post">
		<input type="submit" value="Register">
	</form>
</body>
</html>