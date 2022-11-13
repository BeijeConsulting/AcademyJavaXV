<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Updated article</title>
</head>
<body>

Dettagli articolo:<br><br>
<strong>ID: ${updatedArticle.getId()}</strong><br>
<strong>NOME: ${updatedArticle.getName()}</strong><br>
<strong>TIPOLOGIA: ${updatedArticle.getType()}</strong><br>
<strong>QUANTITA': ${updatedArticle.getQuantity()}</strong><br>
<strong>DESCRZIONE: ${updatedArticle.getDescription()}</strong><br>
<br><br>
Per aggiornare un altro prodotto premere
<form action = "productUpdate">
  <button>Aggiorna</button>
</form>
<br><br>
Per tornare alla lista operazioni premere
<form action = "back">
  <button>Indietro</button>
</form>

</body>
</html>