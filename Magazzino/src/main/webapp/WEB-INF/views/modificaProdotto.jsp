<%--
  Created by IntelliJ IDEA.
  User: Flavio
  Date: 20/10/2022
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica del prodotto presente nel magazzino</title>
</head>
<body>
<p style="color: red">${errore}</p>
<form action="./modificaProdotto" method="post">
  <label for="idProdotto">Inserisci l'identificativo del prodotto :</label><br>
  <input type="text" name="idProdotto" value=""><br>
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
