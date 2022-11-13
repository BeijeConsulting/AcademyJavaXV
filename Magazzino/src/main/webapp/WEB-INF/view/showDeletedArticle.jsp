<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Deleted article</title>
</head>
<body>

Dettagli articolo:<br><br>
<strong>ID: ${deletedArticle.getId()}</strong><br>
<strong>NOME: ${deletedArticle.getName()}</strong><br>
<strong>TIPOLOGIA: ${deletedArticle.getType()}</strong><br>
<strong>QUANTITA': ${deletedArticle.getQuantity()}</strong><br>
<strong>DESCRZIONE: ${deletedArticle.getDescription()}</strong><br>
<br><br>
Per eliminare un altro prodotto premere
<form action = "productDelete">
  <button>Cancella</button>
</form>
<br><br>
Per tornare alla lista operazioni premere
<form action = "back">
  <button>Indietro</button>
</form>

</body>
</html>