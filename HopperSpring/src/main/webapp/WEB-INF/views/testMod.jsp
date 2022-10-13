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
<style>
    th, td {
        border: 1px solid black;
        border-radius: 3px;
    }
</style>
<table style="margin: 0 auto; text-align: center; ">
    <tr>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Email</th>
        <th>ID</th>
    </tr>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.firstName}
            </td>
            <td>${l.lastName}
            </td>
            <td>${l.email}
            </td>
            <td>${l.id}
            </td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
