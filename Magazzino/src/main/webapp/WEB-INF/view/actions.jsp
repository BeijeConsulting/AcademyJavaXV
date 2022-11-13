<%--
  Created by IntelliJ IDEA.
  User: Filippo
  Date: 11/11/2022
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Available operations</title>
</head>
<body>

<strong>QUALE AZIONE VUOI INTRAPRENDERE?</strong>

<form action = "p_list">
    <button>Visualizza lista articoli</button>
</form>
<br><br>
<form action = "product">
    <button>Visualizza dettagli articolo</button>
</form>
<br><br>
<form action = "insertArticle">
    <button>Inserisci nuovo articolo</button>
</form>
<br><br>
<form action = "productUpdate">
    <button>Modifica un articolo</button>
</form>
<br><br>
<form action = "productDelete">
    <button>Cancella un articolo</button>
</form>
<br><br>
<form action = "researchByType">
    <button>Cerca articolo tramite tipologia</button>
</form>
<br><br>
<form action = "researchByName">
    <button>Cerca articolo tramite nome</button>
</form>
<br><br>

</body>
</html>
