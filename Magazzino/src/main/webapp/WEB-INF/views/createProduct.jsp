<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 10:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creazione Prodotto</title>
</head>
<body>
<form action="./addProduct" method="post">
    <label for="name">Nome:</label><br>
    <input type="text" name="name" value=""><br>
    <label for="typology">Tipologia:</label><br>
    <input type="text" name="typology" value=""><br>
    <label for="quantity">Quantità:</label><br>
    <input type="text" name="quantity" value=""><br>
    <label for="description">Descrizione:</label><br>
    <input type="text" name="description" value=""><br><br>
    <input type="submit" value="Inserisci">
</form>
</body>
</html>
