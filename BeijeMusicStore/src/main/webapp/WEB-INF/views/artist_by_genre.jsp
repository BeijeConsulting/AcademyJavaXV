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
<H1 style=color:red>ARTIST BY GENRE</H1>

<c:forEach items="${artisti}" var="a">
	<br><br><strong>NOME:</strong>${a.nome} <strong>GENERE:</strong>${a.genere}
</c:forEach>

</body>
</html>