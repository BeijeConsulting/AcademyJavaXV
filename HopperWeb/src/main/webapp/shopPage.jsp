<%@ page import="it.beije.hopper.ecommerceMod.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="static it.beije.hopper.ecommerceMod.EcommerceJPA.*" %>
<%@ page import="it.beije.hopper.ecommerceMod.models.Cart" %><%--
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
        <form action="./OrderServlet" method="GET">
            <label for="productName">${tempProduct.name}</label>
            <input type="text" name="numOfProduct" value=""><br>
            <input type="submit" value="Add products to cart" id="${tempProduct.id}">
            <input type="hidden" name="submit_id" value="${tempProduct.id}">
        </form>
    </c:forEach>

    <hr>
    <%
        Cart cart = (Cart)session.getAttribute("cartSession");
        System.out.println("Inside shopPage: \n"+ cart);


    %>

    <h2>Your cart </h2>

   <%
       if( cart == null){
        out.println("<p> Empty cart </p>");
       }else{

        //out.println(cart);
           for( Product product : cart.getAllItemsInCart()){
               out.println("<div>");
               out.println("<h4>Product: "+product.getName()+"</h4><br/>");
               out.println("Cost per product: "+product.getPrice()+"<br/>");
               out.println("Description: "+product.getDesc()+"<br/>");
               out.println("Available: "+product.getQuantity()+"<br/>");
               out.println("In cart:"+cart.numberOfProductInCart(product)+"<br/>");
               out.println("Discount:"+cart.singleProductDiscountAmount(product)+"<br/>");
               out.println("Total Discount:"+cart.numberOfProductInCart(product)*cart.singleProductDiscountAmount(product)+"<br/>");
               out.println("Total cost per product:"+( cart.numberOfProductInCart(product) * ( product.getPrice() - cart.singleProductDiscountAmount(product) ) )+"<br/>");
               out.println("<br/>");
               out.println("<div/>");
           }

       }

   %>
    <hr>

    <c:set var="cartC" value="${cart}"/>
    <c:if test="${cart eq null}">
        <p>Your cart is empty</p>
    </c:if>
    <c:if test="${not empty cartC}">

        <div>
            <p><%=session.getAttribute("productId")%></p>
            <p><%= session.getAttribute("numOfProductsInCart") %></p>
        </div>
    </c:if>


</body>
</html>
