<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Ordini</title>
</head>
<body>
Elenco ordini:
<br>
<c:forEach items="${orders}" var="order">
	<br>- ORDINE ID ${order.id} in data ${order.datetime}, euro ${order.amount}:<br>
	<c:forEach items="${order.items}" var="item">
	${item.name} * ${item.quantity}<br>
	</c:forEach>
</c:forEach>
</body>
</html>