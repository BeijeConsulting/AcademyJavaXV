<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 12:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cerca prodotto per tipologia</title>
</head>
<body>
<c:choose>
    <c:when test="${listByTypology==null}">
        <c:forEach items="${productList}" var="l">
            ${l.name}, ${l.typology}<br>
        </c:forEach></c:when>
    <c:otherwise>
        <c:forEach items="${listByTypology}"
                   var="lT">{ ${lT.name}, ${lT.description}, ${lT.quantity}, ${lT.typology} }</c:forEach></c:otherwise></c:choose>

<form action="./findByTypology" method="post">
    <label for="typology">Inserisci la tipologia dei prodotti che vuoi visualizzare:</label><br>
    <input type="text" name="typology" value=""><br>
</form>
</body>
</html>
