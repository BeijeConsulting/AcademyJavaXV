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

	<h1>Cerca canzoni tramite album</h1>

	<p style="color: red">${errore}</p>

	<c:forEach items="${listAlbum}" var="album">
		<br>- ${album.id} ${album.title} 
</c:forEach>

	<form action="./find_song_by_album" method="get">
		<label for="username">Album </label><br> <input type="text"
			name="album" value=""><br> <input type="submit"
			value="Cerca canzoni tramite album">
	</form>

	LISTA CANZONI:
	<c:forEach items="${listSong}" var="song">
		<br>- ${song.title}
</c:forEach>


</body>
</html>