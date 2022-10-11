<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
	<h1>LOGIN</h1>

	<%
	String error =(String)session.getAttribute("error");
		if(error!=null)
			if(error.equals("error")){
	%>
	<p style="color: red">Credenziali errate</p>
	<%
	}
	%>
	<form method="POST" action="login_user">
		 email: <br><input type="text" placeholder="Enter Email" size="40" maxlength="40" name="email" /><br>
		 password: <br><input type="text" placeholder="Enter Password" size="40"maxlength="40" name="password" /><br>
		<button type="submit">login</button>
	</form>



	<form action="signup.jsp" method="post">
		<br> <strong>Se non sei registrato clicca qui: </strong>
		<button type="submit">signup</button>
	</form>

</body>
</html>