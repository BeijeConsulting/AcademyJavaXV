<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<body style="background-color:powderblue;">

<br><br>
<form action="fprodotto">
	<label for="id">Id prodotto da voler cercare:</label><br>
  	<input type="text" name="id" value=""><br>
  	<input type="submit" value="Submit">
</form>

<form action="back">
	<button>Torna alla home</button>
</form>

</body>
</html>