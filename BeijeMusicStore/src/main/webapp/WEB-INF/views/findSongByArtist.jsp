<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 14/10/2022
  Time: 17:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./findSongByArtist" method="post">
    <label for="nome">Inserisci il nome dell'artista:</label><br>
    <input type="text" name="nome" value=""><br>
</form>
<c:forEach items="${canzoni}" var="c">
${c.titolo} ${c.data}
</c:forEach>
</body>
</html>
