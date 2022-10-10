<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 10/10/2022
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop</title>
    <h3>Products</h3>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>max quantity</th>
            <th>Rating</th>
        </tr>
        <c:forEach var="tempProduct" items="${product_list}" >
            <tr>
                <td>${tempProduct.name}</td>
                <td>"sss"</td>
                <td>"sss"</td>
                <td>"sss"</td>
                <td>"sss"</td>

            </tr>
        </c:forEach>

    </table>
</head>
<body>

</body>
</html>
