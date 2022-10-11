
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

<jsp:useBean id="loggedUser" class="it.beije.hopper.entity.User" scope="session"></jsp:useBean>
<jsp:setProperty property="email" name="loggedUser" param="email"/>
<jsp:setProperty property="password" name="loggedUser" param="password"/>

	<%
	//String fname = request.getParameter("email");
	//String password = request.getParameter("password");
	//String email = (String) session.getAttribute("email");
	//String password = (String) session.getAttribute("");
	%>
	
	<%if(loggedUser.getEmail()==null || loggedUser.getPassword()==null)
	response.sendRedirect("loguser.jsp");
	%>
	
	<strong>FIRST NAME :</strong><%=loggedUser.getName() %><br><strong> LAST NAME :</strong><%=loggedUser.getSurname()%><br><strong> EMAIL :</strong><%=loggedUser.getEmail()%><br>
	<br>

	<form action="ProdServlet">
		<button type="submit">Visualizza prodotti nello store</button>
	</form>
	
	<form action="LogoutUserServlet">
		<button type="submit">logout</button>
	</form>

</body>
</html>