<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 20/10/2022
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ricerca Prodotti per tipologia nel magazzino</title>
</head>
<body>
<p style="color: red">${errore}</p>
    <form action="./ricercaPerTipologia" method="post">
        <label for="tipoProdotto">Inserisci la tipologia del prodotto da ricercare:</label><br>
        <input type="text" name="tipoProdotto" value=""><br>
        <input type="submit" value="Submit">
    </form>
    <c:forEach items="${risultato}" var="result">
        <br>Nome del prodotto: ${result.nome},  Tipologia del prodotto: ${result.tipologia},
        Quantità presente nel magazzino: ${result.quantita}, Descrizione del prodotto: ${result.descrizione}<br>
    </c:forEach>
</body>
</html>
