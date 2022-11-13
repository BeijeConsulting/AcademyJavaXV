<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert data</title>
</head>
<body>
INSERIRE I DATI DELL'ARTICOLO DA INSERIRE<br><br>
<form action="product_insertion">
  <label for="name">Nome: </label><br>
  <input type="text" name="name" value=""><br><br>
  <label for="type">Tipologia: </label><br>
  <input type="text" name="type" value=""><br><br>
  <label for="quantity">Quantita': </label><br>
  <input type="text" name="quantity" value=""><br><br>
  <label for="description">Descrizione: </label><br>
  <input type="text" name="description" value=""><br><br>
  <input type="submit" value="Salva"><br><br>
</form>

<form action="back">
  <button>Indietro</button>
</form>

</body>
</html>