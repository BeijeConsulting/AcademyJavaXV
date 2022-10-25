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
    <title>(3) CANZONI tramite l'ALBUM</title>
</head>


<body>
<span>
  <h2>(3) CANZONI tramite l'ALBUM</h2>
  <div>

    <h3>Lista di Canzoni</h3>
    <ul>
      <c:forEach var="canzoni" items="${canzoni}" >
        <li>${canzoni.nome}</li>
      </c:forEach>
    </ul>

  </div>

  <div >
    <h3>Lista di album</h3>
    <ul>
      <c:forEach var="albums" items="${albums}" >
        <li>${albums.titolo} - ${albums.data}</li>
      </c:forEach>
    </ul>
  </div>



</span>
<div>

  <hr>
  <h3> Inserisci nome dell' album </h3>
  <form action="./canzonibyalbum" method="GET">
    <label for="albumNome">nome artista:</label><br>
    <input type="text" name="albumNome" value=""><br><br>
    <input type="submit" value="Submit">
  </form>


</div>
</body>
</html>
