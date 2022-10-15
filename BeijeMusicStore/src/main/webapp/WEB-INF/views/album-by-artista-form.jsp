<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 15/10/2022
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>(2) ALBUM tramite l'ARTISTA</title>
</head>


<body>
<span>
  <h2>(2) ALBUM tramite l'ARTISTA</h2>
  <div>

    <h3>Lista di artisti</h3>
    <ul>
      <c:forEach var="artists" items="${artists}" >
        <li>${artists.nome}</li>
      </c:forEach>
    </ul>

  </div>

  <div >
    <h3>Lista di album</h3>
    <ul>
      <c:forEach var="listAlbum" items="${listAlbum}" >
        <li>${listAlbum}</li>
      </c:forEach>
    </ul>
  </div>



</span>
<div>

  <hr>
  <h3> Inserisci Genere dell' artista</h3>
  <form action="./artistibygenre" method="GET">
    <label for="artistGenere">Genere:</label><br>
    <input type="text" name="artistGenere" value=""><br><br>
    <input type="submit" value="Submit">
  </form>


</div>
</body>
</html>
