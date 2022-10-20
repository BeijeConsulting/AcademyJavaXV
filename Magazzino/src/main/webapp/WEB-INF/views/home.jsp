<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body  style="text-align: center" topmargin="200px">
<h1>BENVENUTO SU HOPPERMUSIC</h1><br>

<h4>effettua la tua ricerca:</h4>

    <p style="font-family:Comic Sans MS" >
        <a href="/Magazzino/product">Prodotti</a> |
        <a href="#" onclick="document.getElementById('prodottoById').removeAttribute('hidden');document.getElementById('addProd').setAttribute('hidden','hidden')">Prodotto tamite Id</a> |
        <a href="#" onclick="document.getElementById('addProd').removeAttribute('hidden');document.getElementById('prodottoById').setAttribute('hidden','hidden')">Aggiungi prodotto</a> |
   
    </p>

<div id="product" hidden="hidden">
    <form action="./product" method="get">
        <label for="prodotti">Prodotti:</label>
        <input type="text" name="prodotti" value="" id="prodotti">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="prodottoById" hidden="hidden">
    <form action="./prodottoById" method="post">
        <label for="prodotto">Id Prodotto:</label>
        <input type="text" name="prodotto" value="" id="prodotto">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="addProd" hidden="hidden">
    <form action="./addProd" method="post">
  <label for="name">NOME:</label><br>
  <input type="text" name="name" value=""><br>
  <label for="tipo">TIPOLOGIA:</label><br>
  <input type="text" name="tipo" value=""><br><br>
  <label for="quantity">QUANTITà:</label><br>
  <input type="text" name="quantity" value=""><br><br>
  <label for="desc">DESCRIZIONE:</label><br>
  <input type="text" name="desc" value=""><br><br>
  <input type="submit" value="Submit">
</form>
</div>



</body>
</html>