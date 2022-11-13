<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Product to insert</title>
</head>
<body>

<strong>INFORMAZIONI PRODOTTO INSERITO:</strong><br><br>
<strong>ID: ${savedArticle.id}</strong><br>
<strong>NOME: ${savedArticle.name}</strong><br>
<strong>TIPOLOGIA: ${savedArticle.type}</strong><br>
<strong>DISPONIBILI: ${savedArticle.quantity}</strong><br>
<strong>DESCRIZIONE: ${savedArticle.description}</strong><br><br>

Per inserire un nuovo articolo premere
<form action="insertArticle">
  <button>Inserisci</button>
</form>
<br><br>
Per tornare alla lista delle operazioni premere
<form action="back">
  <button>Indietro</button>
</form>

</body>
</html>