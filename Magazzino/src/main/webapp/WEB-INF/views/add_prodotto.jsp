<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 10/20/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new product</title>
    <h2>Add info about the new product</h2>
</head>
<body>
    <form action="add" method = "post">
        <br> Nome:  <input type = "text" name = "nomeProdotto" value = "">
        <br> <br> Tipologia: <input type = "text" name = "tipoProdotto" value = "">
        <br><br> Quantita: <input type = "text" name = "quantitaProdotto" value = "">
        <br><br> Descrizione: <input type = "text" name = "descrizioneProdotto" value = "">
        <input type="submit" value="Aggiungi">

    </form>
</body>
</html>
