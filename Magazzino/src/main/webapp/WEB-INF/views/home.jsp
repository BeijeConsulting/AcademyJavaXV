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
        <a href="#" onclick="document.getElementById('prodottoById').removeAttribute('hidden');document.getElementById('addProd').setAttribute('hidden','hidden');document.getElementById('modProd').setAttribute('hidden','hidden');document.getElementById('prodottoByTipo').setAttribute('hidden','hidden');document.getElementById('prodottoByNomeDesc').setAttribute('hidden','hidden');document.getElementById('spedizioneContenuto').setAttribute('hidden','hidden')">Prodotto tamite Id</a> |
        <a href="#" onclick="document.getElementById('addProd').removeAttribute('hidden');document.getElementById('prodottoById').setAttribute('hidden','hidden');document.getElementById('modProd').setAttribute('hidden','hidden');document.getElementById('prodottoByTipo').setAttribute('hidden','hidden');document.getElementById('prodottoByNomeDesc').setAttribute('hidden','hidden');document.getElementById('spedizioneContenuto').setAttribute('hidden','hidden')">Aggiungi prodotto</a> |
   	 	<a href="#" onclick="document.getElementById('modProd').removeAttribute('hidden');document.getElementById('addProd').setAttribute('hidden','hidden');document.getElementById('prodottoById').setAttribute('hidden','hidden');document.getElementById('prodottoByTipo').setAttribute('hidden','hidden');document.getElementById('prodottoByNomeDesc').setAttribute('hidden','hidden');document.getElementById('spedizioneContenuto').setAttribute('hidden','hidden')">Modifica prodotto</a> |
   	 	<a href="/Magazzino/delete" >Elimina prodotto</a> |
   	 	<a href="#" onclick="document.getElementById('prodottoByTipo').removeAttribute('hidden');document.getElementById('addProd').setAttribute('hidden','hidden');document.getElementById('prodottoById').setAttribute('hidden','hidden');document.getElementById('modProd').setAttribute('hidden','hidden');document.getElementById('prodottoByNomeDesc').setAttribute('hidden','hidden');document.getElementById('spedizioneContenuto').setAttribute('hidden','hidden')">Prodotti per tipologia</a> |
   	 	<a href="#" onclick="document.getElementById('prodottoByNomeDesc').removeAttribute('hidden');document.getElementById('addProd').setAttribute('hidden','hidden');document.getElementById('prodottoById').setAttribute('hidden','hidden');document.getElementById('modProd').setAttribute('hidden','hidden');document.getElementById('prodottoByTipo').setAttribute('hidden','hidden');document.getElementById('spedizioneContenuto').setAttribute('hidden','hidden')">Prodotti per nome o desc</a> |
   	 	<a href="/Magazzino/spedizioni" >Lista Spedizioni</a> |
   	 	<a href="#" onclick="document.getElementById('spedizioneContenuto').removeAttribute('hidden');document.getElementById('addProd').setAttribute('hidden','hidden');document.getElementById('prodottoById').setAttribute('hidden','hidden');document.getElementById('modProd').setAttribute('hidden','hidden');document.getElementById('prodottoByTipo').setAttribute('hidden','hidden');document.getElementById('prodottoByNomeDesc').setAttribute('hidden','hidden')">Contenuto Spedizioni</a> |
   	 	
    </p>
    
    
    <div id="spedizioneContenuto" hidden="hidden">
    <form action="./spedizioneContenuto" method="get">
        <label for="id">Id spedizione:</label>
        <input type="text" name="id" value="" id="id">
        <input type="submit" value="Cerca">
    </form>
</div>

<div id="prodottoByNomeDesc" hidden="hidden">
    <form action="./prodottoByNomeDesc" method="get">
        <label for="name">Nome Prodotto:</label>
        <input type="text" name="name" value="" id="name">
        <label for="desc">descrizione Prodotto:</label>
        <input type="text" name="desc" value="" id="desc">
        <input type="submit" value="Cerca">
    </form>
</div>


<div id="prodottoByTipo" hidden="hidden">
    <form action="./prodottoByTipo" method="get">
        <label for="tipo">Tipo Prodotto:</label>
        <input type="text" name="tipo" value="" id="tipo">
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

<div id="modProd" hidden="hidden">
    <form action="./modProd" method="post">
     <label for="id">ID:</label><br>
  <input type="text" name="id" value=""><br>
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