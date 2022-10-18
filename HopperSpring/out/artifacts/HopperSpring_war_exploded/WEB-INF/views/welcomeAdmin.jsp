<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 13/10/2022
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Benvenuto Admin!</title>
</head>
<body style="text-align: center" bgcolor="#7fffd4" topmargin="200px">

<br>
<h1>BENVENUTO : Admin ${loggedUser.lastName}!!!</h1>
<br>
<br>

<%--
<c:choose>
	<c:when test=""></c:when>
	<c:otherwise></c:otherwise>
</c:choose>
--%>
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
        <td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')">Inserisci Prodotto</a></td>
        <td><a href="#"  onclick="win = window.open('removeProduct.html', 'Elimina Prodotto', 'location=yes,width=400,height=400')">Elimina Prodotto</a></td>
    </tr>
    <tr>
        <td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')">Inserisci Prodotto</a></td>
        <td><a href="#"  onclick="win = window.open('removeProduct.html', 'Elimina Prodotto', 'location=yes,width=400,height=400')">Elimina Prodotto</a></td>
    </tr>
</table>

</body>
</html>
