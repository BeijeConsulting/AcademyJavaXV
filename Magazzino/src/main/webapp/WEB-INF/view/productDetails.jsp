<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Product Details</title>
</head>
<body>

Dettagli articolo:<br><br>
<strong>NOME: ${selectedArticle.getName()}</strong><br>
<strong>TIPOLOGIA: ${selectedArticle.getType()}</strong><br>
<strong>QUANTITA': ${selectedArticle.getQuantity()}</strong><br>
<strong>DESCRZIONE: ${selectedArticle.getDescription()}</strong><br>

<form action = "back">
  <button>Indietro</button>
</form>

</body>
</html>