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
		<td><a href="#"  onclick="document.getElementById('addC').removeAttribute('hidden');document.getElementById('carrello').removeAttribute('hidden');document.getElementById('infO').setAttribute('hidden','hidden')">Effettua un nuovo ordine</a></td>
		<td><a href="#"  onclick="document.getElementById('infO').removeAttribute('hidden');document.getElementById('addC').setAttribute('hidden','hidden');document.getElementById('carrello').setAttribute('hidden','hidden')">Visualizza uno dei tuoi ordini</a></td>
	</tr>
</table>

<c:if test="${not empty carrello}">
	<div id="addC">
</c:if>
<c:if test="${empty carrello}">
	<div id="addC" hidden="hidden">
</c:if>
	<form action="./addCarrello" method="post">
		<label for="id">Id Prodotto:</label><br>
		<input type="text" name="id" value=""><br><br>
		<label for="quantita">Quantità:</label><br>
		<input type="text" name="quantita" value=""><br><br>
		<input type="submit" value="Aggiungi">
	</form>
</div>

<div id="infO" hidden="hidden">
	<form action="./viewOrderUser" method="post">
		<label for="id">Id Ordine:</label><br>
		<input type="text" name="id" value=""><br><br>
		<input type="submit" value="Visualizza">
	</form>
</div>

<div id="carrello">
	<p style="color: mediumvioletred">
		<b>
			<c:forEach items="${carrello}" var="item">
				${item}<br>
			</c:forEach>
		</b>
	</p>

	<c:if test="${not empty carrello}">
		<form action="./confirmOrder" method="post">
			<input type="submit" value="Conferma">
		</form>
		<form action="./deleteCarrello" method="post">
			<input type="submit" value="Cancella">
		</form>
	</c:if>
</div>
	<p style="color: green"><b>${result}</b></p>

</body>
</html>