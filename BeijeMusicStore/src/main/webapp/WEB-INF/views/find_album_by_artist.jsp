<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Cerca album tramite artista</h1>

<c:forEach items="${listArtist}" var="artist">
	<br>- ${artist.id} ${artist.name} 
</c:forEach>

	<form action="./find_album_by_artist" method="get">
		<label for="username">Artista </label><br> <input type="text"
			name="artist" value=""><br> <input type="submit"
			value="Cerca album tramite artista">
	</form>
	
	LISTA ALBUM:
	<c:forEach items="${listAlbum}" var="album">
	<br>- ${album.title}
</c:forEach>

</body>
</html>