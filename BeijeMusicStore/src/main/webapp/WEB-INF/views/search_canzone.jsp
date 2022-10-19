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

<h1>Trova canzoni: </h1>


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



<h3>Trova Canzoni dall'artista: </h3>
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


<h3>Trova Canzoni dal genere: </h3>
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

</body>
</html>