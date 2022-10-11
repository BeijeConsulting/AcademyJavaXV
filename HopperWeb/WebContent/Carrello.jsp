<%@page import="it.beije.hopper.web.ecommerce.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>
CARRELLO<br><br>

<%

List<Product> ris = (List<Product>)session.getAttribute("carr");

	for (Product p: ris){
		%>
		<br>
		   <%= p %>
		  
		  <% 
		 
	System.out.println(p);
	}
%>
<br><br>
<input type="button" onclick="location.href='product.jsp'" value="torna"/>
