<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Ecommerce</title>
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
<div style="text-align: center; margin: auto">
<form action="./loginMod" method="GET">
    <input type="submit" value="login">
</form>

<form action="signUp.jsp" method="post">
    <input type="submit" value="signup">
</form>
</div>
</body>
</html>