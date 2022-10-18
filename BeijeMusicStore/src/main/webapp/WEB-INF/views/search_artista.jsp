<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>WELCOME PAGE</title>
</head>
<body>

<h1>LISTA SERVIZI: </h1>

<h3>Trova artisti dal genere: </h3>
<form action="./artista_by_genere" method="get">
    <label for="genere">Scegli il genere che interessa:</label>
    <input list="generi" name="genere" id="genere">
    <datalist id="generi">
        <c:forEach items="${generiArtisti}" var="genere">
        <option value=${genere}>
            </c:forEach>
    </datalist>
    <input type="submit">
</form>


<h3>Trova artista dalla canzone: </h3>
<form action="./artista_by_id" method="get">
    <label for="id">Scegli l'artista che ti interessa:</label>
    <input list="artisti2" name="id" id="id">
    <datalist id="artisti2">
        <c:forEach items="${canzoni}" var="canzone">
            <option value=${canzone.artista_id}>${canzone.titolo}</option>
        </c:forEach>
    </datalist>
    <input type="submit">
</form>


</body>
</html>