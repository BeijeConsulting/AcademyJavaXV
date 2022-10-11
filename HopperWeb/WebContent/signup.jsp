<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<style>
button {
	margin: 10px 0px;
	cursor: pointer;
}

button:hover {
	color: red;
}
</style>
<body>
	<h1>SIGNUP</h1>

	<%
	String error = (String) session.getAttribute("errorSignup");

	if (error != null)
		if (error.equals("error")) {
	%>
	<p style="color: red">Credenziali errate</p>
	<%
	}
	%>

	<form method="POST" action="signup_user">
		<strong>Name: <br></strong><input type="text" placeholder="Enter name" size="40" maxlength="40" name="nome" /><br> 
		<strong>Lastname:<br> </strong> <input type="text" placeholder="Enter lastname" size="40" maxlength="40" name="cognome" /><br>
		<strong>email:<br></strong><input type="text" placeholder="Enter email" size="40" maxlength="40" name="email" /><br> 
		<strong>password:<br></strong><input type="text" placeholder="Enter password" size="40" maxlength="40" name="password" /><br>
		<button type="submit">create</button>
	</form>

</body>
</html>