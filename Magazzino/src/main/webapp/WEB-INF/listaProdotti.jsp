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

<c:forEach items="prodotti" var="p">
	<br><strong>ID PRODOTTO: </strong> ${p.id} <strong>NOME: </strong> ${p.nome} <strong>TIPOLOGIA: </strong> ${p.tipologia}
	<strong>QUANTITA': </strong> ${p.quantità} <strong>DESCRIZIONE: </strong> ${p.descrizione} <strong>;</strong>
</c:forEach>

</body>
</html>