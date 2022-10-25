<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 15/10/2022
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>(2) ALBUM tramite l'ARTISTA </title>
</head>
<body>
        <h3> (2) ALBUM tramite l'ARTISTA </h3>
        <table border="1">
            <tr>
                <th>Titolo</th>
                <th>Data</th>
                <th>Genere</th>
            </tr>
            <c:forEach var="albums" items="${albums}" >
                <tr>
                    <td>${albums.titolo}</td>
                    <td>${albums.data}</td>
                    <td>${albums.genere}</td>

                </tr>
            </c:forEach>
        </table>
</body>
</html>
