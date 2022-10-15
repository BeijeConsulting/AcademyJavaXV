<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beije Music Store </title>
</head>
<body>
<h3>  Beije Music Store  </h3>


    <div>
        <a href="artistibygenre-form"> (1) - Pagina che restituisce gli ARTISTI tramite il GENERE </a>
    </div>
    <div>
        <a href="albumbyartista-form"> (2) - Pagina che restituisce l'ALBUM tramite l'ARTISTA </a>
    </div>

<%--<%--%>
<%--/*--%>
<%--User loggedUser = (User) session.getAttribute("loggedUser");--%>

<%--System.out.println(loggedUser.getFirstName());--%>
<%--System.out.println(loggedUser.getLastName());--%>
<%--int x = 10+5;--%>
<%--*/--%>

<%--//KO!!! -> System.out.println("sono nella welcome.jsp : " + ${loggedUser});--%>
<%--%>--%>

<%--<br>--%>
<%--FIRST NAME : ${loggedUser.firstName}<br>--%>
<%--LAST NAME : ${loggedUser.lastName}<br>--%>
<%--<br>--%>
<%--<c:if test="${loggedUser.firstName eq 'Pippo'}">CIAO PIPPO!!!</c:if>--%>
<%--&lt;%&ndash;--%>
<%--<c:choose>--%>
<%--	<c:when test=""></c:when>--%>
<%--	<c:otherwise></c:otherwise>--%>
<%--</c:choose>--%>


<%--<br>--%>
<%--LISTA:--%>
<%--<c:forEach items="${orders}" var="order">--%>
<%--	<br>- ORDINE ID ${order.id} in data ${order.datetime}, euro ${order.amount}:<br>--%>
<%--	<c:forEach items="${order.items}" var="item">--%>
<%--	${item.name} * ${item.quantity}<br>--%>
<%--	</c:forEach>--%>
<%--</c:forEach>--%>
</body>
</html>