<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <title>Hello Spring MVC</title>
   </head>
   <body>
      <h1>Ciao! :-) provaRest</h1>
      <c:forEach items="${lista}" var="user">
	<br>- ${user}
</c:forEach>
   </body>
</html>