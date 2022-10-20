<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 20/10/2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DETTAGLIO</title>
</head>
<body style="text-align: center" bgcolor="#7fffd4" topmargin="200px">
<c:if test="${not empty dettaglio}">
    <h1>Dettaglio:</h1>
</c:if>
<c:if test="${not empty editP}">
    <h1>Dettaglio Prodotto Modificato:</h1>
</c:if>
<c:if test="${not empty deleteP}">
    <h1>Prodotto Eliminato:</h1>
</c:if>

${dettaglio}
${editP}
${deleteP}
</body>
</html>
