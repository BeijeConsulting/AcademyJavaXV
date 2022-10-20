<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="articolo" var="a">
	<br><strong>ID PRODOTTO: </strong> ${a.id} <strong>NOME: </strong> ${a.nome} <strong>TIPOLOGIA: </strong> ${a.tipologia}
	<strong>QUANTITA': </strong> ${a.quantità} <strong>DESCRIZIONE: </strong> ${a.descrizione} <strong>;</strong>
</c:forEach>

</body>
</html>