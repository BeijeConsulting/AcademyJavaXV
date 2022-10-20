<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 20/10/2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Modify Product</title>
</head>
<body>
    <h3>Modifying Product ${productToMod.name}</h3>
<%--    <br>--%>
    <div>

        Id: ${productToMod.id}
        <br>
        <form:form action="./modifyingproduct" modelAttribute="product" method="POST">
            Id: <form:input path="id"/>
            <br>
            Name: <form:input path="name"/>
            <br>
            Type: <form:input path="type"/>
            <br>
            Quantity:  <form:input path="quantity"/>
            <br>
            Description:  <form:input path="description"/>
            <br>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>


</body>
</html>
