<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Show article by name</title>
</head>
<body>

Dettagli articolo:<br><br>
<strong>ID: ${articleByName.getId()}</strong><br>
<strong>NOME: ${articleByName.getName()}</strong><br>
<strong>TIPOLOGIA: ${articleByName.getType()}</strong><br>
<strong>QUANTITA': ${articleByName.getQuantity()}</strong><br>
<strong>DESCRZIONE: ${articleByName.getDescription()}</strong><br>
<br><br>
Per cercare ancora per nome premere
<form action = "researchByName">
  <button>Aggiorna</button>
</form>
<br><br>
Per tornare alla lista operazioni premere
<form action = "back">
  <button>Indietro</button>
</form>

</body>
</html>