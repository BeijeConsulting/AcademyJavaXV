<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Search article by type</title>
</head>
<body>

<form action="article_byType">
  <label for="type">Inserire la tipologia di articolo: </label>
  <input type="text" name="type" value=""><br><br>
  <button>Cerca</button>
</form>

</body>
</html>