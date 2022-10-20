<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 11:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Elimina prodotto</title>
</head>
<body>
<p style="color: #c62727">
    ${error}
</p>

<c:forEach items="${productList}" var="l">
    ${l.id}, ${l.name}, ${l.description}<br>
</c:forEach>

<form action="./deleteProduct" method="post">
    <label for="id">Inserisci l'id del prodotto che vuoi eliminare:</label><br>
    <input type="text" name="id" value=""><br>
</form>
</body>
</html>
