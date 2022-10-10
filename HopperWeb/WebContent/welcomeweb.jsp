
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<style>
button {
	cursor: pointer;
}

button:hover {
	color: red;
}
</style>
<body>

	<%
	//String fname = request.getParameter("email");
	//String password = request.getParameter("password");

	String email = (String) session.getAttribute("email");
	String password = (String) session.getAttribute("password");
	%>


	FIRST NAME :
	<%=email%><br> Password :
	<%=password%><br>
	<br>

	<form action="listaprodotti.jsp">
		<button type="submit">Visualizza prodotti nello store</button>
	</form>

</body>
</html>