<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 12:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cerca prodotto tramite nome e tipologia</title>
</head>
<body>
<c:forEach items="${listByName}" var="list">{${list.name}, ${list.description}, ${list.typology}, ${list.quantity}} <br><br></c:forEach>
<form action="./findbynameandtypo" method="post">
    <label for="name">Inserisci il nome dei prodotti che vuoi visualizzare:</label><br>
    <input type="text" name="name" value=""><br>
    <label for="typology">Inserisci il tipo dei prodotti che vuoi visualizzare:</label><br>
    <input type="text" name="typology" value=""><br>
    <input type="submit" name="submit" value="Cerca"><br>
</form>
</body>
</html>
