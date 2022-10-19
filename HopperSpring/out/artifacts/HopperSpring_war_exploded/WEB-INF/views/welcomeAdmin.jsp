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
<body style="text-align: center" bgcolor="#7fffd4"> <!-- top-margin="100px" -->

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
        <td><a href="#"  onclick="document.getElementById('newP').removeAttribute('hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('infP').setAttribute('hidden','hidden')">Inserisci Prodotto</a></td>
        <td><a href="#"  onclick="document.getElementById('infP').removeAttribute('hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden')">Dettaglio Ordine</a></td>
    </tr>
    <tr>
        <td><a href="#"  onclick="document.getElementById('editP').removeAttribute('hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('infP').setAttribute('hidden','hidden')">Modifica Prodotto</a></td>
    </tr>
    <tr>
        <td><a href="#"  onclick="document.getElementById('deleteP').removeAttribute('hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('infP').setAttribute('hidden','hidden')">Elimina Prodotto</a></td>
    </tr>
</table>


<div id="newP" hidden="hidden">
    <form action="./newProduct" method="post">
        <label for="nome">Nome:</label><br>
        <input type="text" name="nome" value=""><br>
        <label for="descrizione">Descrizione:</label><br>
        <input type="text" name="descrizione" value=""><br>
        <label for="prezzo">Prezzo:</label><br>
        <input type="text" name="prezzo" value=""><br>
        <label for="quantita">Quantità:</label><br>
        <input type="text" name="quantita" value=""><br><br>
        <label for="rate">Rate:</label><br>
        <input type="text" name="rate" value=""><br><br>
        <label for="promo">Promo:</label><br>
        <input type="text" name="promo" value=""><br><br>
        <input type="submit" value="Inserisci">
    </form>
</div>

<div id="editP" hidden="hidden">
    <form action="./editProduct" method="post">
        <label for="id">Id:</label><br>
        <input type="text" name="id" value=""><br><br>
        <label for="campo">Campo:</label><br>
        <input type="text" name="campo" value=""><br><br>
        <label for="valore">Valore:</label><br>
        <input type="text" name="valore" value=""><br><br>
        <input type="submit" value="Modifica">
    </form>
</div>

<div id="deleteP" hidden="hidden">
    <form action="./deleteProduct" method="post">
        <label for="id">Id:</label><br>
        <input type="text" name="id" value=""><br><br>
        <input type="submit" value="Elimina">
    </form>
</div>

<div id="infP" hidden="hidden">
    <form action="./infOrdine" method="post">
        <label for="id">Id:</label><br>
        <input type="text" name="id" value=""><br><br>
        <input type="submit" value="Visualizza">
    </form>
</div>

<table style="margin: auto">
    <tr>
        <td>
            <p style="color: green"><b>${result}</b></p>
        </td>
    </tr>
</table>
</body>
</html>
