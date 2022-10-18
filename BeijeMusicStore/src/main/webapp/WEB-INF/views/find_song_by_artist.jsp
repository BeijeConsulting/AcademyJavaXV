<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Cerca canzoni tramite artista</h1>

	<p style="color: red">${errore}</p>

	<form action="./find_song_by_artist" method="get">
		<label for="username">Artist </label><br> <input type="text"
			name="artist" value=""><br> <input type="submit"
			value="Cerca canzoni tramite artista">
	</form>

	LISTA CANZONI:
	<c:forEach items="${listSong}" var="song">
		<br>- ${song.title}
</c:forEach>


</body>
</html>