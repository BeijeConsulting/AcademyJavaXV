<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 20/10/2022
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricerca del prodotto tramite ID</title>
</head>
<body>
<p style="color: red">${errore}</p>
    <form action="./prodottoPerId" method="post">
        <label for="idprodotto">Inserisci l'ID del prodotto da cercare:</label><br>
        <input type="text" name="idprodotto" value=""><br>
        <input type="submit" value="Submit">
    </form>
    <div>${prodotto.toString()}</div>
</body>
</html>
