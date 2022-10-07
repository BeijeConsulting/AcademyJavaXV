<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>
<%
String fname = (String) session.getAttribute("fname");
String lname = (String) session.getAttribute("lname");
%>

<br>
QUESTE LE TUE CREDENZIALI<br><br>
FIRST NAME : <%= fname %><br>
LAST NAME : <%= lname %>

</body>
</html>