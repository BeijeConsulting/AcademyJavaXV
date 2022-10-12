<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>testosterone</title>
</head>
<body>
Questa è una classe ad alto tasso di testosterone
<br>
LISTA:
<c:forEach items="${lista}" var="l">
	<br>${l}
</c:forEach>
</body>
</html>