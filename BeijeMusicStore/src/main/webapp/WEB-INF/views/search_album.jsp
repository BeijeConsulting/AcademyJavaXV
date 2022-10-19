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

<h1>Cerca album: </h1>

<h3>Trova Album dall'artista: </h3>
<form action="./album_by_artista" method="get">
    <label for="id_artista_for_album">Scegli l'artista che ti interessa:</label>
    <input list="artisti3" name="id_artista_for_album" id="id_artista_for_album">
    <datalist id="artisti3">
        <c:forEach items="${artisti}" var="artista">
            <option value=${artista.id}>${artista.nome}</option>
        </c:forEach>
    </datalist>
    <input type="submit">
</form>


<h3>Trova Album dal genere: </h3>
<form action="./album_by_genere" method="get">
    <label for="genereAlbum">Scegli il genere che interessa:</label>
    <input list="generiAlbum" name="genereAlbum" id="genereAlbum">
    <datalist id="generiAlbum">
        <c:forEach items="${generiAlbum}" var="genere">
        <option value=${genere}>
            </c:forEach>
    </datalist>
    <input type="submit">
</form>


<h3>Trova album dalla canzone: </h3>
<form action="./album_by_id" method="get">
    <label for="albums_id">Scegli l'artista che ti interessa:</label>
    <input list="albums_id" name="album_id" id="album_id">
    <datalist id="albums_id">
        <c:forEach items="${canzoni}" var="canzone">
            <option value=${canzone.album_id}>${canzone.titolo}</option>
        </c:forEach>
    </datalist>
    <input type="submit">
</form>



</body>
</html>