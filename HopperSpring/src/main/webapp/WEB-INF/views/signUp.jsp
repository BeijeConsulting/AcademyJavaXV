<%--
  Created by IntelliJ IDEA.
  User: toni-
  Date: 10/10/2022
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registrati</title>
</head>
<body>
<p style="color: red">
  <%
    String error = (String) session.getAttribute("error");
    if (error != null) {
      out.print(error);
      session.removeAttribute("error");
    }
  %>
</p>

<form action="${pageContext.request.contextPath}/SignupServlet" method="post">
  <label for="fname">Nome:</label><br>
  <input type="text" name="fname" value=""><br>
  <label for="lname">Cognome:</label><br>
  <input type="text" name="lname" value=""><br>
  <label for="email">E-Mail:</label><br>
  <input type="text" name="email" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password" value=""><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>