<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update prodotto</title>
</head>
<body>

<p style="color: red">${errore}</p>
<p style="color: darkseagreen">${success}</p>
<h3>Aggiorna prodotto</h3>
<form action="./update_prodotto" method="post">
    <label for="id">ID:</label><br>
    <input type="text" name="id" value="${prodotto.id}" readonly><br>
    <label for="nome">Nome:</label><br>
    <input type="text" name="nome" value="${prodotto.nome}"><br>
    <label for="tipologia">Tipologia:</label><br>
    <input type="text" name="tipologia" value="${prodotto.tipologia}"><br>
    <label for="quantita">Quantita':</label><br>
    <input type="number" name="quantita" value="${prodotto.quantita}"><br>
    <label for="descrizione">Descrione:</label><br>
    <input type="text" name="descrizione" value="${prodotto.descrizione}"><br>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>