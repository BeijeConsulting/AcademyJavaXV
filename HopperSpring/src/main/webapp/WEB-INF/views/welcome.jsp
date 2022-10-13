<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<br>
FIRST NAME : ${loggedUser.firstName}<br>
LAST NAME : ${loggedUser.lastName}<br>
<br>
<c:if test="${loggedUser.firstName eq 'Pippo'}">CIAO PIPPO!!!</c:if>
<%--
<c:choose>
	<c:when test=""></c:when>
	<c:otherwise></c:otherwise>
</c:choose>
--%>

<br>
LISTA:
<c:forEach items="${products}" var="product">
	${product} <br>
</c:forEach>
</body>
</html>