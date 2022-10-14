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
<h1>FILIPPO ANDREA</h1>
<c:forEach items="${artisti}" var="a">
	<br><br><strong>NOME:</strong>${a.nome} <strong>GENERE:</strong>${a.genere}
</c:forEach>

</body>
</html>