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


	<h1>PRODOTTI</h1>
	Cart:${cartsize}
   	<c:forEach items="${products}" var="p">
		<br>${p.name}
		<br>${p.desc}
		<br>${p.price}
		<form>
		<button>add to cart</button>
		</form>
			
	</c:forEach>
	<br>

</body>
</html>