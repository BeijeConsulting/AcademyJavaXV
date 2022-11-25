<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista_prodotti</title>
</head>
<body>
Elenco Prodotti Magazzino:
<br>
LISTA:
<c:forEach items="${lista}" var="prod">
	<br>- ${prod}
</c:forEach>
</body>
</html>