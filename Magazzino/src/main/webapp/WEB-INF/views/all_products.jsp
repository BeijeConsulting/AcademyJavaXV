<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 10/20/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
<p1>List of all products in stock:</p1>
<br>
<c:forEach items="${lista}" var = "prodotto">
        <br> ${prodotto.nome}
</c:forEach>

</body>
</html>
