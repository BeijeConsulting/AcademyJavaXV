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

	<h1>Lista spedizioni</h1>
	
	<br><br>
	<p style="color: red">${error}</p>
	<c:forEach items="${shipments}" var="shipment">
		<br>- ${shipment}
	</c:forEach>

</body>
</html>