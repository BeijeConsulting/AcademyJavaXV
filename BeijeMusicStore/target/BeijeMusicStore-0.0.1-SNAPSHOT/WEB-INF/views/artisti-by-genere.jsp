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
    <title>(1) ARTISTI tramite il GENERE </title>
</head>
<body>
        <h3> (1) ARTISTI tramite il GENERE </h3>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Genere</th>
            </tr>
            <c:forEach var="artists" items="${artists}" >
                <tr>
                    <td>${artists.nome}</td>
                    <td>${artists.genere}</td>

                </tr>
            </c:forEach>
        </table>
</body>
</html>
