<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TEST LOGIN</title>
</head>
<body>

<jsp:useBean id="loggedUser" class="it.beije.hopper.web.User" scope="session"></jsp:useBean>
<jsp:setProperty property="firstName" name="loggedUser" param="fname"/>
<jsp:setProperty property="lastName" name="loggedUser" param="lname"/>

<%
/*
String fname = request.getParameter("fname");
loggedUser.setFirstName(fname);
String lname = request.getParameter("lname");
loggedUser.setLastName(lname);
*/

System.out.println("loggedUser : " + loggedUser);

%>

FIRST NAME : <jsp:getProperty property="firstName" name="loggedUser"/><br>
LAST NAME : <jsp:getProperty property="lastName" name="loggedUser"/>

</body>
</html>