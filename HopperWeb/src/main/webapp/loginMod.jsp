<%--
  Created by IntelliJ IDEA.
  User: toni-
  Date: 10/10/2022
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="./LoginServletMod" method="post">
  <label for="email">Email:</label><br>
  <input type="text" name="email" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password" value=""><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
