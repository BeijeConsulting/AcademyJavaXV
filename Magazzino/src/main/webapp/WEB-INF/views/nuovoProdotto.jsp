<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 20/10/2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserimento prodotto nel database</title>
</head>
<p style="color: red">${errore}</p>
<body>
    <form action="./nuovoProdotto" method="post">
        <label for="nomeProdotto">Inserisci il nome del prodotto :</label><br>
        <input type="text" name="nomeProdotto" value=""><br>
        <label for="tipologiaProdotto">Inserisci la tipologia del prodotto :</label><br>
        <input type="text" name="tipologiaProdotto" value=""><br>
        <label for="quantita">Inserisci la quantit&agrave del prodotto nel magazzino :</label><br>
        <input type="text" name="quantita" value=""><br>
        <label for="descrizione">Inserisci una breve descrizione del prodotto :</label><br>
        <input type="text" name="descrizione" value=""><br>
        <input type="submit" value="Submit">
    </form>
    <div>${stato}</div>
</body>
</html>
