<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Product List</title>
</head>
<body>

<c:forEach items="articlesList" var="p">
  <br>Nome: ${p.name}<br>Tipologia: ${p.type}<br>Quantità: ${p.quantity}<br>Descrizione: ${p.description}<br><br>
</c:forEach>

<form action="back">
  <button>Indietro</button>
</form>

</body>
</html>