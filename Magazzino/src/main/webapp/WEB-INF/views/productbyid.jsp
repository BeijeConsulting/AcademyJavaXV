<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 20/10/2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pagina che restituisce il dettaglio del prodotto tramite id</title>
</head>
<body>
    <h3>Pagina che restituisce il dettaglio del prodotto tramite id</h3>
<%--    <br>--%>
    <div>
        <h4>Product page</h4>
        Id: ${productWithInfo.id}
        <br>
        Name: ${productWithInfo.name}
        <br>
        Type: ${productWithInfo.type}
        <br>
        Quantity: ${productWithInfo.quantity}
        <br>
        Quantity: ${productWithInfo.description}
        <br>
    </div>


</body>
</html>
