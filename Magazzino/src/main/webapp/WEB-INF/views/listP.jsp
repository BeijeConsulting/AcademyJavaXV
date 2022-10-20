<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 20/10/2022
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Prodotti</title>
</head>
<body style="text-align: center" bgcolor="#7fffd4" topmargin="200px">
<h1>Lista Prodotti:</h1><br><br>
<c:forEach items="${prodotti}" var="prodotto">
  ${prodotto}<br>
</c:forEach>

</body>
</html>
