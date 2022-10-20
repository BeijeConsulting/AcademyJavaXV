<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spedizioni</title>
</head>
<body>
<body style="background-color:powderblue;">
<c:forEach items="${spedizione}" var="s">
	<br><strong>Codice:</strong>${s.codice} <strong><br>DESTINATARIO:</strong>${s.destinatario}
	<strong>INDIRIZZO:</strong>${s.indirizzo}<br> <strong>DATA SPEDIZIONE:</strong>${s.dataSpedizione}
	<strong>DATA RICEZIONE:</strong>${s.dataRicezione}<br>
</c:forEach>

<form action="back">
	<button>Torna alla home</button>
</form>
</body>
</html>