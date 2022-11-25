<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista_spedizioni</title>
</head>
<body>
Elenco Spedizioni:
<br>
LISTA:
<c:forEach items="${lista}" var="sped">
	<br>- ${sped}
</c:forEach>
</body>
</html>