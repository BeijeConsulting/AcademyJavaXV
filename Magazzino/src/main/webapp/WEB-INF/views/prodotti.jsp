<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotti</title>
</head>
<body>
<c:forEach items="${prodotti}" var="p">
	<br><strong>Nome:</strong>${p.nome} <strong>TIPOLOGIA:</strong>${p.tipologia} 
	<strong>QUANTITA':</strong>${p.quantita} <strong>DESCRIZIONE:</strong>${p.descrizione}
</c:forEach>

</body>
</html>