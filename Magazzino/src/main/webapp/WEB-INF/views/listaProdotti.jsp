<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 20/10/2022
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Elenco prodotti disponibili</title>
</head>
<body>
  <c:forEach items="${listaDeiProdotti}" var="prodotto">
    <br>ID del prodotto: ${prodotto.id}, Nome del prodotto: ${prodotto.nome},
    Tipologia del prodotto: ${prodotto.tipologia}, Quantità presente nel magazzino: ${prodotto.quantita},
    Descrizione del prodotto: ${prodotto.descrizione}<br>
  </c:forEach>
</body>
</html>
