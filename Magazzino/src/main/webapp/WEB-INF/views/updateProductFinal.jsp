<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 11:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica Prodotto</title>
</head>
<body>
<form action="./updateProductFinal" method="post">
    <input type="hidden" name="id" value="${product.id}"><br>
    <label for="name">Nome:</label><br>
    <input type="text" name="name" value="${product.name}"><br>
    <label for="typology">Tipologia:</label><br>
    <input type="text" name="typology" value="${product.typology}"><br>
    <label for="quantity">Quantità:</label><br>
    <input type="text" name="quantity" value="${product.quantity}"><br>
    <label for="description">Descrizione:</label><br>
    <input type="text" name="description" value="${product.description}"><br><br>
    <input type="submit" value="Modifica">
</form>
</body>
</html>
