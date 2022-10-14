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

<h3>Trova album dall'artista: </h3>
<form action="./album_by_artista" method="get">
    <label for="id_artista">Scegli l'artista che ti interessa:</label>
    <input list="artisti3" name="id_artista_for_album" id="id_artista_for_album">
    <datalist id="artisti3">
        <c:forEach items="${artisti}" var="artista">
            <option value=${artista.id}>${artista.nome}</option>
        </c:forEach>
    </datalist>
    <input type="submit">
</form>

<h3>Trova Canzoni tramite l'Album: </h3>
<form action="./canzoni_by_album" method="get">
    <label for="album">Scegli il genere che ti interessa:</label>
    <input list="albums" name="album" id="album">
    <datalist id="albums">
        <c:forEach items="${albums}" var="album">
        <option value=${album.id} label=${album.titolo}>
            </c:forEach>
    </datalist>
    <input type="submit">
</form>

<%--
<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce le CANZONI tramite l'ARTISTA");
}%>
</a>
--%>

<h3>Trova canzone dall'artista: </h3>
<form action="./canzoni_by_artista" method="get">
    <label for="id_artista">Scegli l'artista che ti interessa:</label>
    <input list="artisti" name="id_artista" id="id_artista">
    <datalist id="artisti">
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

<h3>Trova canzoni dal genere: </h3>
<form action="./canzone_by_genere" method="get">
    <label for="genereCanzoni">Scegli il genere che interessa:</label>
    <input list="generiCanzoni" name="genereCanzoni" id="genereCanzoni">
    <datalist id="generiCanzoni">
        <c:forEach items="${generiCanzoni}" var="genere">
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