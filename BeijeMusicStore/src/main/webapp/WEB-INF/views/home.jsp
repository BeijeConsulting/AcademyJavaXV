<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Benvenuto</h1>

	<form action="./find_artist_by_genre" method="get">
		<input type="submit" value="Cerca Artista tramite genere">
	</form>
	
	<form action="./find_album_by_artist" method="get">
		<input type="submit" value="Cerca Album tramite artista">
	</form>
	
	<form action="./find_song_by_album" method="get">
		<input type="submit" value="Cerca canzoni tramite album">
	</form>
	
	<form action="./find_song_by_artist" method="get">
		<input type="submit" value="Cerca canzoni tramite artista">
	</form>

</body>
</html>