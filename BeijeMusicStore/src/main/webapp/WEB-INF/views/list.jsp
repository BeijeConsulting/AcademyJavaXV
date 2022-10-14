<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Risultati azioni</title>
</head>
<body>



<br>
<h3>Risultati:</h3>
<c:forEach items="${listaAlbum}" var="album">
  <br>- Album ID ${album.id} Titolo ${album.titolo} in data ${album.data} euro ${album.numeroCanzoni}:<br>
  <c:forEach items="${album.canzoni}" var="canzoni">
    ${canzoni.titolo} * ${canzoni.genere}<br>
  </c:forEach>
</c:forEach>

<c:forEach items="${listaAlbum}" var="album">
  <br>- Album ID ${album.id} Titolo ${album.titolo} in data ${album.data} euro ${album.numeroCanzoni}:<br>
  <c:forEach items="${album.canzoni}" var="canzoni">
    ${canzoni.titolo} * ${canzoni.genere}<br>
  </c:forEach>
</c:forEach>
</body>
</html>