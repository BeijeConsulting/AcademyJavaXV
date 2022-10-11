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

<style>
button {
	margin: 10px 0px;
	cursor: pointer;
	align: right;
}



</style>

<body>

<h1>Benvenuti nel nostro ecommerce</h1>

<div align="right">
	<form action="./login_user.jsp" method="post">
		<button type="submit" value="Login">login</button>
		<button type="submit" value="Register">register</button>
	</form>
</div>


<jsp:useBean id="loggedUser" class="it.beije.hopper.web.ecommerce.User" scope="session"></jsp:useBean>
<jsp:setProperty property="email" name="loggedUser" param="email"/>
<jsp:setProperty property="password" name="loggedUser" param="password"/>
<% 
	//String fname = request.getParameter("fname");
	//String lname = request.getParameter("lname");
	
	//loggedUser.getName();
	
	//String fname = (String) session.getAttribute("fname");
	//String lname = (String) session.getAttribute("lname");
	
	String fname = loggedUser.getName();
	String lname = loggedUser.getSurname();
	
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





</body>
</html>