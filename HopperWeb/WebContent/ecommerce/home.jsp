<%@page import="java.util.*"%>
<%@page import="it.beije.hopper.web.ecommerce.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Benvenuti nel nostro ecommerce</h1>
<% 
	//String fname = request.getParameter("fname");
	//String lname = request.getParameter("lname");
	
	String fname = (String) session.getAttribute("fname");
	String lname = (String) session.getAttribute("lname");
	
	//System.out.println( (String) session.getAttribute("fname") );
	//System.out.println( (String) session.getAttribute("lname") ) ;
	
	String error = (String) session.getAttribute("errore");
	
	if (error != null) {
	out.print(error);
	session.removeAttribute("errore");
	
	}else{ 
		%>FIRST NAME : <%= fname %><br> 
		LAST NAME : <%= lname %><br><% 
	}
%>



<%
	List<Product> products = ProductConnections.getAllProducts();
	for(Product p : products){
		out.print(p.toString() );
		%> <br> <% 
	}
%>



	<form action="../loginEcommerce" method="post">
		<label for="username">Username:</label><br> 
		<input type="text"name="username" value=""><br> <label for="password">Password:</label><br>
		<input type="password" name="password" value=""><br>
		<input type="submit" value="Login">
	</form>

	<form action="../registerEcommerce" method="post">
  <input type="submit" value="Register">
</form>

</body>
</html>