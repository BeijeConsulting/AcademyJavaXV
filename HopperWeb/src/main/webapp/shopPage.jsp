<%@ page import="it.beije.hopper.ecommerceMod.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="static it.beije.hopper.ecommerceMod.EcommerceJPA.*" %><%--
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

</head>

<body>
    <h3>Available Products</h3>
    <%
        List<Product> products = getAllProducts();
        System.out.println(products);
    %>
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
                <td>${tempProduct.desc}</td>
                <td>${tempProduct.price}</td>
                <td>${tempProduct.quantity}</td>
                <td>${tempProduct.rating}</td>

            </tr>
        </c:forEach>

    </table>
    <hr>
    <br/>

<%--    <form action="" method="get">--%>



<%--    </form>--%>
    <c:forEach var="tempProduct" items="${product_list}" >

        <div>
            <h4>Product Name</h4>
        </div>
        <form action="./login" method="post">
            <label for="${tempProduct.id}">${tempProduct.name}</label>
            <input type="text" name="${tempProduct.name}" value=""><br>
            <input type="submit" value="Add products to cart">
        </form>
    </c:forEach>
</body>
</html>
