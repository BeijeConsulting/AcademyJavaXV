<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista_prodotti per tipologia nome</title>
</head>
<body>
Elenco Prodotti per tipologia nome:
<br>
LISTA:
<c:forEach items="${prodotti}" var="prod">
	<br>- ${prod}
</c:forEach>
</body>
</html>