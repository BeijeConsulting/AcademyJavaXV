<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 10/20/2022
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find by tipo</title>
</head>
<body>
<form action = "findbytipo" method = "get">
   tipo: <input type = "text" name = "tipoProdotto" value = "">
    <input type="submit" value="Cerca">
</form>
Lista di tutti i prodotti per il tipo selezionato <br>
<c:forEach items="${listaProdotti}" var = "prodotto">
    <br> ${prodotto.nome}
</c:forEach>
</body>
</html>
