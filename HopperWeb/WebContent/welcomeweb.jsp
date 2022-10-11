<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

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

<jsp:useBean id="loggedUser" class="it.beije.hopper.entity.User" scope="session"></jsp:useBean>
<jsp:setProperty property="email" name="loggedUser" param="email"/>
<jsp:setProperty property="password" name="loggedUser" param="password"/>
	
	<%if(loggedUser.getEmail()==null || loggedUser.getPassword()==null)
	response.sendRedirect("loguser.jsp");
	%>
	
	<strong>FIRST NAME :</strong><%=loggedUser.getName() %><br><strong> LAST NAME :</strong><%=loggedUser.getSurname()%><br><strong> EMAIL :</strong><%=loggedUser.getEmail()%><br>
	<br>

	<form action="ProdServlet">
		<button type="submit">Visualizza prodotti nello store</button>
	</form>



	<form method="POST" action="LogoutUserServlet">
		<button type="submit">logout</button>
	</form>

</body>
</html>

