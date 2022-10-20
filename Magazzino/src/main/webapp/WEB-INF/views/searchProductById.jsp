<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 10:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cerca Prodotto</title>
</head>
<body>
${productDetail} ${error}<br><br>


<c:forEach items="${list}" var="l">
    ${l.id} ${l.name}<br>
</c:forEach>

<form action="./searchProduct" method="post">
    <label for="id">Inserisci l'id del prodotto che vuoi visualizzare:</label><br>
    <input type="text" name="id" value=""><br>
</form>
</body>
</html>
