<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 10/20/2022
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <form action="update" method = "post"><br>
        <br> Id: <input type = "text" name = "idProdotto" value = "">
        <br> Nome:  <input type = "text" name = "nomeProdotto" value = "">
        <br> <br> Tipologia: <input type = "text" name = "tipoProdotto" value = "">
        <br><br> Quantita: <input type = "text" name = "quantitaProdotto" value = "">
        <br><br> Descrizione: <input type = "text" name = "descrizioneProdotto" value = "">
        <input type="submit" value="Update">
    </form>
</body>
</html>
