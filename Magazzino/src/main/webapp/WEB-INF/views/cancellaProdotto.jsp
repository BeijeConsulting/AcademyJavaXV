<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 20/10/2022
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cancellazione del prodotto tramite ID del Magazzino</title>
</head>
<body>
<p style="color: red">${errore}</p>
<form action="./cancellaProdotto" method="post">
    <label for="idProdotto">Inserisci l'identificativo del prodotto :</label><br>
    <input type="text" name="idProdotto" value=""><br>
    <input type="submit" value="Submit">
</form>
<div>${stato}</div>
</body>
</html>
