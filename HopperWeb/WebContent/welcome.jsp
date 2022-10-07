<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<%
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");

//System.out.println( (String) session.getAttribute("fname") );
//System.out.println( (String) session.getAttribute("lname") ) ;


System.out.print(fname);
System.out.print(lname);
int x = 10+5;
String timestamp = LocalDateTime.now().toString();
%>

<strong><%= timestamp %></strong>
<br>
FIRST NAME : <%= fname %><br>
LAST NAME : <%= lname %>

</body>
</html>