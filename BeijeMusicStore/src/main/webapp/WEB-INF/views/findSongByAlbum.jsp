<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 14/10/2022
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${canzoni}
    <form action="./findSongByAlbum" method="post">
        <label for="nomeAlbum">Inserire nome dell'album</label><br>
        <input type="text" name="nomeAlbum" value=""><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
