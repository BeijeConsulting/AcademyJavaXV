<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Show article by type</title>
</head>
<body>

Dettagli articolo:<br><br>

<c:forEach items="articleByTyper" var="aBt">
  <strong>ID: ${aBt.getId()}</strong><br>
  <strong>NOME: ${aBt.getName()}</strong><br>
  <strong>TIPOLOGIA: ${aBt.getType()}</strong><br>
  <strong>QUANTITA': ${aBt.getQuantity()}</strong><br>
  <strong>DESCRZIONE: ${aBt.getDescription()}</strong><br>
  <br><br>
</c:forEach>

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