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

Database aggiornato

<br><strong>Codice:</strong>${spedizione.codice} <strong><br>DESTINATARIO:</strong>${spedizione.destinatario}
	<strong>INDIRIZZO:</strong>${spedizione.indirizzo}<br> <strong>DATA SPEDIZIONE:</strong>${spedizione.dataSpedizione}
	<strong>DATA RICEZIONE:</strong>${spedizione.dataRicezione}<br>

<form action="back">
	<button>Torna alla home</button>
</form>
</body>
</html>