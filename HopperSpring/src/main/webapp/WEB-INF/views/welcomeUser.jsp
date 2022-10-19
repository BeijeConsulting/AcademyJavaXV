<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body style="text-align: center" bgcolor="#7fffd4">

<br>
<h1>BENVENUTO : ${loggedUser.firstName} ${loggedUser.lastName}!!!</h1>
<br>
<br>
<br>
<table style="margin: auto" >
	<tr>
		<th style="border-style: solid">LISTA PRODOTTI</th>
		<th style="border-style: solid">LISTA ORDINI</th>
	</tr>
	<tr>
		<td style="border-style: solid">
			<c:forEach items="${products}" var="product">
				${product} <br>
			</c:forEach>
		</td>
		<td style="border-style: solid">
			<c:forEach items="${orders}" var="order">
				${order} <br>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td><a href="#"  onclick="win = window.open('newOrder.html', 'Nuovo Ordine', 'location=yes,width=400,height=400')">Effettua un nuovo ordine</a></td>
		<td><a href="#"  onclick="win = window.open('viewOrder.html', 'Visualizza Ordine', 'location=yes,width=400,height=400')">Visualizza uno dei tuoi ordini</a></td>
	</tr>
</table>

</body>
</html>