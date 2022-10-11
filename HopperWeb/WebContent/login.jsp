<%@page import="it.beije.hopper.web.ecommerce.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP</title>
</head>
<body>

<%--
String error = request.getParameter("error");
if (error != null) {
	%>
	<p style="color: red">
	<%
	if (error.equals("1")) out.print("CREDENZIALI ERRATE");
	else out.print("INSERIRE ENTRAMBE LE CREDENZIALI");
	%>
	</p>
	<%
}
--%>

<p style="color: red">
<%

String error = (String) session.getAttribute("errore");
if (error != null) {
	out.print(error);
	session.removeAttribute("errore");
}


%>
</p>


<form action="./login" method="post">
  <label for="username">Username:</label><br>
  <input type="text" name="username" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password" value=""><br><br>
  <input type="submit" value="submit" >
</form>

</body>
</html>