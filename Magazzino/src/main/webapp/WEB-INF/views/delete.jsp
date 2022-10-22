<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>deletePage</title>
</head>
<body  style="text-align: center" topmargin="200px">

<h4>Inserisci il prodotto da cancellare:</h4>




<div id="delete">
    <form action="./delete" method="post">
        <label for="id">Id Prodotto:</label>
        <input type="text" name="id" value="" id="id">
        <input type="submit" value="Submit">
    </form>
</div>






</body>
</html>