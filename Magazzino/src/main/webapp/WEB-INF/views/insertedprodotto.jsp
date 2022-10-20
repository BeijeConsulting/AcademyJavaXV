<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<c:choose>
    <c:when test="${stringa=='update'}">
        Prodotto aggiornato
        <br />
    </c:when>
    <c:when test="${stringa=='delete'}">
        Prodotto eliminato
        <br />
    </c:when>     
    <c:when test="${stringa=='insert'}">
        Prodotto eliminato
        <br />
    </c:when>
</c:choose>


${prodotto}

</body>
</html>