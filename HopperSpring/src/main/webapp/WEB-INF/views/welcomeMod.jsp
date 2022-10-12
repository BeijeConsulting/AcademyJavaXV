<%--
  Created by IntelliJ IDEA.
  User: toni-
  Date: 12/10/2022
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">
Benvenuto ${name} <br>
${email}
</h1>
<h2 style="text-align: center">
    <c:forEach items="${list}" var="l"> ${l} </c:forEach>
</h2>
</body>
</html>
