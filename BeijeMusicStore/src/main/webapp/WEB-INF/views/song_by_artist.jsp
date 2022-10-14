<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SONG BY ALBUM</title>
</head>
<body>
<H1 style=color:red>SONG BY ALBUM</H1>

<c:forEach items="${canzoni}" var="c">
	<br><br><strong>ID ARTISTA:</strong>${c.artistaId}<strong>ID ARTISTA:</strong>${c.albumId} <strong>TITOLO:</strong>${c.titolo} 
	<strong>DATA USCITA:</strong>${c.dataDiUscita} <strong>GENERE:</strong>${c.genere}
</c:forEach>

</body>
</html>