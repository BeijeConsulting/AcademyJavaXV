<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 23/11/2022
  Time: 12:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    fetch('http://localhost:8080/Magazzino/rest/deleteProduct/${id}', {
        method: 'DELETE',

    });
</script>
</body>
</html>
