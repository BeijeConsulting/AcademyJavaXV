<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 17:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cerca tramite prodotto</title>
</head>
<body>
${spedizioneTrovata}<br>
<c:forEach items="${list}" var="prod">${prod.id}, ${prod.name}<br> </c:forEach>

<form action="./findSpedizioneByProduct" method="post">
  <label for="id">Inserisci l'id del prodotto che vuoi visualizzare:</label><br>
  <input type="number" name="id" value=""><br>
</form>
</body>
</html>
