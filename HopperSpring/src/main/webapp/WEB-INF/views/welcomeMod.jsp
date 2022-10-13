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
<style>
    input[type=button], input[type=submit], input[type=reset] {
        background-color: #04AA6D;
        border: none;
        color: white;
        padding: 16px 32px;
        text-decoration: none;
        margin: 4px 2px;
        cursor: pointer;
    }
</style>
<h1 style="text-align: center">
    Benvenuto ${user.firstName} ${user.lastName} <br>
    <form action="./orderHistory" method="POST">
        <input type="hidden" name="userId" value=${user.id}>
        <input type="submit" value="Storico Ordini">
    </form>

</h1>
<h2 style="text-align: center">

</h2>
</body>
</html>
