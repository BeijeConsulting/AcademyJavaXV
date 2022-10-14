<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 14/10/2022
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body  style="text-align: center" bgcolor="#7fffd4" topmargin="200px">
<h1>BENVENUTO SU HOPPERMUSIC</h1><br>

<table style="margin: auto">
    <th>ARTISTI</th>
    <th>ALBUM</th>
    <tr>
        <td style="border-style: solid">
            <c:forEach items="${artistiHome}" var="artista">
                ${artista} <br>
            </c:forEach>
        </td>
        <td style="border-style: solid">
            <c:forEach items="${albumsHome}" var="album">
                ${album} <br>
            </c:forEach>
        </td>
    </tr>
</table>



<h4>effettua la tua ricerca:</h4>

    <p style="font-family:Comic Sans MS" >
        <a href="#" onclick="document.getElementById('GtoAr').removeAttribute('hidden');document.getElementById('ArtoAl').setAttribute('hidden','hidden');document.getElementById('AltoC').setAttribute('hidden','hidden');document.getElementById('ArtoC').setAttribute('hidden','hidden');document.getElementById('GtoAl').setAttribute('hidden','hidden');document.getElementById('GtoC').setAttribute('hidden','hidden')">Artista tramite Genere</a> |
        <a href="#" onclick="document.getElementById('ArtoAl').removeAttribute('hidden');document.getElementById('GtoAr').setAttribute('hidden','hidden');document.getElementById('AltoC').setAttribute('hidden','hidden');document.getElementById('ArtoC').setAttribute('hidden','hidden');document.getElementById('GtoAl').setAttribute('hidden','hidden');document.getElementById('GtoC').setAttribute('hidden','hidden')">Album tramite Artista</a> |
        <a href="#" onclick="document.getElementById('AltoC').removeAttribute('hidden');document.getElementById('ArtoAl').setAttribute('hidden','hidden');document.getElementById('GtoAr').setAttribute('hidden','hidden');document.getElementById('ArtoC').setAttribute('hidden','hidden');document.getElementById('GtoAl').setAttribute('hidden','hidden');document.getElementById('GtoC').setAttribute('hidden','hidden')">Canzoni tramite Album</a> |
        <a href="#" onclick="document.getElementById('ArtoC').removeAttribute('hidden');document.getElementById('ArtoAl').setAttribute('hidden','hidden');document.getElementById('AltoC').setAttribute('hidden','hidden');document.getElementById('GtoAr').setAttribute('hidden','hidden');document.getElementById('GtoAl').setAttribute('hidden','hidden');document.getElementById('GtoC').setAttribute('hidden','hidden')">Canzoni tramite Artista</a> |
        <a href="#" onclick="document.getElementById('GtoC').removeAttribute('hidden');document.getElementById('ArtoAl').setAttribute('hidden','hidden');document.getElementById('AltoC').setAttribute('hidden','hidden');document.getElementById('GtoAr').setAttribute('hidden','hidden');document.getElementById('GtoAl').setAttribute('hidden','hidden');document.getElementById('ArtoC').setAttribute('hidden','hidden')">Canzoni tramite Genere</a> |
        <a href="#" onclick="document.getElementById('GtoAl').removeAttribute('hidden');document.getElementById('ArtoAl').setAttribute('hidden','hidden');document.getElementById('AltoC').setAttribute('hidden','hidden');document.getElementById('GtoAr').setAttribute('hidden','hidden');document.getElementById('ArtoC').setAttribute('hidden','hidden');document.getElementById('GtoC').setAttribute('hidden','hidden')">Album tramite Genere</a>
    </p>

<div id="GtoAr" hidden="hidden">
    <form action="./GtoAr" method="post">
        <label for="genere">Genere:</label>
        <input type="text" name="genere" value="" id="genere">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="ArtoAl" hidden="hidden">
    <form action="./ArtoAl" method="post">
        <label for="artista">Artista:</label>
        <input type="text" name="artista" value="" id="artista">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="AltoC" hidden="hidden">
    <form action="./AltoC" method="post">
        <label for="album">Album:</label>
        <input type="text" name="album" value="" id="album">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="ArtoC" hidden="hidden">
    <form action="./ArtoC" method="post">
        <label for="artistaC">Artista:</label>
        <input type="text" name="artistaC" value="" id="artistaC">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="GtoAl" hidden="hidden">
    <form action="./GtoAl" method="post">
        <label for="genere2">Genere:</label>
        <input type="text" name="genere2" value="" id="genere2">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="GtoC" hidden="hidden">
    <form action="./GtoC" method="post">
        <label for="genere3">Genere:</label>
        <input type="text" name="genere3" value="" id="genere3">
        <input type="submit" value="Cerca">
    </form>
</div>
<br>

<table style="margin: auto">
    <tr>
        <td  style="border-style: solid">
            <c:forEach items="${artisti}" var="artista">
                ${artista} <br>
            </c:forEach>
            <c:forEach items="${albums}" var="album">
                ${album} <br>
            </c:forEach>
            <c:forEach items="${canzoni1}" var="canzone">
                ${canzone} <br>
            </c:forEach>
            <c:forEach items="${canzoni2}" var="canzone">
                ${canzone} <br>
            </c:forEach>
            <c:forEach items="${albums1}" var="canzone">
                ${canzone} <br>
            </c:forEach>
            <c:forEach items="${canzoni3}" var="canzone">
                ${canzone} <br>
            </c:forEach>
        </td>
    </tr>
</table>

</body>
</html>
