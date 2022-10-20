<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 15:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cerca Spedizione</title>
</head>
<body>
${spedizioneTrovata}<br><br>

<p style="color: #c62727">
    ${error}
</p>
<c:forEach items="${spedizioniList}" var="list"><b>${list.id}</b>.... ${list.codice}, ${list.destinatario}, ${list.dataSpedizione}
    <br><br></c:forEach>

<form action="./findSpedizioneById" method="post">
    <label for="id">Inserisci l'id della spedizione che vuoi visualizzare:</label><br>
    <input type="number" name="id" value=""><br>
</form>
</body>
</html>
