<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 14/10/2022
  Time: 15:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Genere</title>
</head>
<body>
<c:if test="${errore==0}">Nessun artista trovato!</c:if>
<c:forEach items="${risultato}" var="r">
${r.nome}
</c:forEach>


<form action="./findByGenere" method="post">
    <label for="genere">Genere:</label><br>
    <input type="text" name="genere" value=""><br>
</form></body>
</html>
