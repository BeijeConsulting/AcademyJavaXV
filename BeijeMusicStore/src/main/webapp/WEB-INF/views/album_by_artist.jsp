<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ARTIST BY GENRE</title>
</head>
<body>
<H1 style=color:red>ALBUM BY ARTIST</H1>

<c:forEach items="${album}" var="a">
	<br><br><strong>ID ARTISTA:</strong>${a.artistaId} <strong>TITOLO:</strong>${a.titolo} 
	<strong>DATA USCITA:</strong>${a.dataDiUscita} <strong>GENERE:</strong>${a.genere}
</c:forEach>

</body>
</html>