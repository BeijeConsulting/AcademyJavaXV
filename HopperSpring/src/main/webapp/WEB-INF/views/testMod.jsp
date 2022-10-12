<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 12/10/2022
  Time: 12:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="l">${l.firstName}, </c:forEach>

</body>
</html>
