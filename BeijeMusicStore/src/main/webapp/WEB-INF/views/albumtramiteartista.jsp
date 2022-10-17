<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Album Tramite Artista</title>
</head>
<body>

<form action="./albumtramiteartista" method="post">
  <label for="nome">artista:</label><br>
  <input type="text" name="nome" value=""><br>
  <input type="submit" value="Submit">
<!--${risultato}-->
${risultato}
<c:forEach items="${risultato}" var="ris">
	<br>- ${ris.titolo}
</c:forEach>
</form>
</body>
</html>