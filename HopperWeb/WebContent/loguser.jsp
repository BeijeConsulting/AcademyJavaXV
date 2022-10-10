<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	
	<%
		String error=(String)session.getAttribute("error");
		if(error.equals("error")){
	%>
		<p style="color: red">Credenziali errate</p>
	<%} %>
	<form method="POST" action="login_user">
		email: <input type="text" size="40" maxlength="40" name="email"/><br/>
		password: <input type="text" size="40" maxlength="40" name="password"/><br/>
		
		<input type="submit" value="login">
	</form>
	
	
	
	<form action="signup.html" method="post">
		<strong>se non sei registrato clicca qui </strong>
		<input type="submit" value="signup">
	</form>
</body>
</html>