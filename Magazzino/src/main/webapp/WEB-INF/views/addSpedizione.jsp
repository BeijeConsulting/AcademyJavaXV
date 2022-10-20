<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 20/10/2022
  Time: 16:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crea Spedizione</title>
</head>
<body>
<form action="./addSpedizione" method="post">
  <label for="name">Nome:</label><br>
  <input type="text" name="name" value=""><br>
  <label for="indirizzo">Indirizzo:</label><br>
  <input type="text" name="indirizzo" value=""><br>
  <input type="submit" value="Inserisci">
</form>
</body>
</html>
