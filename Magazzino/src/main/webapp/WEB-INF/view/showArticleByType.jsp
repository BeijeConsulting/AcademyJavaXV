<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Show article by type</title>
</head>
<body>

Dettagli articolo:<br><br>
<strong>ID: ${articleByType.getId()}</strong><br>
<strong>NOME: ${articleByType.getName()}</strong><br>
<strong>TIPOLOGIA: ${articleByType.getType()}</strong><br>
<strong>QUANTITA': ${articleByType.getQuantity()}</strong><br>
<strong>DESCRZIONE: ${articleByType.getDescription()}</strong><br>
<br><br>
Per cercare ancora per tipologia premere
<form action = "researchByType">
  <button>Aggiorna</button>
</form>
<br><br>
Per tornare alla lista operazioni premere
<form action = "back">
  <button>Indietro</button>
</form>

</body>
</html>