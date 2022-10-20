<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 17:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contenuto</title>
</head>
<body>
<c:forEach items="${productList}" var="product">${product.name}, ${product.description}, ${product.typology}, ${product.quantity}</c:forEach>
<form action="./addSpedizioneCont" method="post">
  <input type="hidden" name="id" value="${spedizione}"><br>
  <label for="idProdotto">Inserisci l'id del prodotto che vuoi aggiungere:</label><br>
  <input type="number" name="idProdotto" value=""><br>
  <label for="quantita">Inserisci la quantità:</label><br>
  <input type="text" name="quantita" value=""><br>
  <input type="submit" value="Inserisci">
  </form>

<form action="./findAllSpedizioni" method="get">
  <input type="submit" value="Fine">
</form>
</body>
</html>
