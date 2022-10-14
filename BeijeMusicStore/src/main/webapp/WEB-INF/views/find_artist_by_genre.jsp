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
<h1>Cerca artista tramite genere</h1>

	<form action="./find_artist_by_genre" method="get">
		<label for="username">Genere </label><br> <input type="text"
			name="genre" value="genre"><br> <input type="submit"
			value="Cerca Artista tramite genere">
	</form>
	
	LISTA ARTISTI:
	<c:forEach items="${listArtist}" var="artist">
	<br>- ${artist.name}
</c:forEach>
</body>
</html>