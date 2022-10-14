<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 13/10/2022
  Time: 16:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Storico Ordini</title>
</head>
<body>
<style>
    th, td {
        border: 1px solid black;
        border-radius: 3px;
    }
</style>
<table style="margin: 0 auto; text-align: center; border-style: solid">
<tr>
    <th>ID</th>
    <th>Data</th>
    <th>Prodotti</th>
</tr>
<c:forEach items="${orderHistory}" var="o">
    <tr>
            <td>${o.id}
            </td>
            <td>${o.datetime}
            </td>
    <c:forEach items="${o.items}" var="oI">
       <td><table style="margin: 0 auto; text-align: center;">
           <tr><th>Desc</th>
           <th>ID</th>
           <th>Prezzo</th></tr>
           <td> ${oI.desc}</td> <td>${oI.id}</td> <td>${oI.price}</table></td>

    </c:forEach>

    </c:forEach>
    </tr></td>
</table>
</body>
</html>
