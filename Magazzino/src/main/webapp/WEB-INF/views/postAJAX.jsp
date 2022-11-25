<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 23/11/2022
  Time: 12:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    fetch('http://localhost:8080/Magazzino/rest/addProduct', {
        method: 'POST',
        body: JSON.stringify({
            name: '${product.name}',
            typology: '${product.typology}',
            quantity: ${product.quantity},
            description: "${product.description}",
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((json) => console.log(json));
</script>
<form action="./home" method="get">
    <input type="submit" value="Torna indietro"></form>

</body>
</html>
