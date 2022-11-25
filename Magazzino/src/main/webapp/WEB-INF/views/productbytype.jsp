<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 20/10/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>


</head>
<body>
<title>Products by type (JS)</title>
<h3> Pagina che restituisce la lista di tutti i prodotti di una specifica tipologia </h3>
<h2> Products of type ${type}</h2>
<table border="1">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Type</th>
        <th>Available quantity</th>
        <th>Description</th>
    </tr>
<%--    <c:forEach var="tempProduct" items="${products}" >--%>
<%--        <tr>--%>
<%--            <td>${tempProduct.id}</td>--%>
<%--            <td>${tempProduct.name}</td>--%>
<%--            <td>${tempProduct.type}</td>--%>
<%--            <td>${tempProduct.quantity}</td>--%>
<%--            <td>${tempProduct.description}</td>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>

</table>
<hr>
</body>
</html>
