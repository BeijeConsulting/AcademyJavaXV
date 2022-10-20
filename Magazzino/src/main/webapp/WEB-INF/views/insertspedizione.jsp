<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<body style="background-color:powderblue;">

<form action="inspedizione" method="post">
  <label for="codice">Codice Spedizione:</label><br>
  <input type="text" name="codice" value=""><br>
  <label for="destinatario">Destinatario spedizione:</label><br>
  <input type="text" name="destinatario" value=""><br>
  <label for="indirizzo">Indirizzo spedizione:</label><br>
  <input type="text" name="indirizzo" value=""><br>
  <label for="dataSpedizione">Data spedizione:(yyyy-mm-dd)</label><br>
  <input type="text" name="dataSpedizione" value=""><br>
  <label for="dataRicezione">Data ricezione:(yyyy/-mm-dd)</label><br>
  <input type="text" name="dataRicezione" value=""><br><br>
  <input type="submit" value="Submit">
</form>

<form action="back">
	<button>Torna alla home</button>
</form>

</body>
</html>