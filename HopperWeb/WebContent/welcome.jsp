<%@ page import="java.time.LocalDateTime"%>
<%@ page import="jakarta.persistence.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="it.beije.hopper.web.Product" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<%
//String fname = request.getParameter("fname");
//String lname = request.getParameter("lname");

String fname = (String) session.getAttribute("fname");
String lname = (String) session.getAttribute("lname");


//System.out.print(fname);
//System.out.print(lname);

String timestamp = LocalDateTime.now().toString();
%>

<strong><%= timestamp %></strong>
<br>
FIRST NAME : <%= fname %><br>
LAST NAME : <%= lname %><br>

</body>
</html>