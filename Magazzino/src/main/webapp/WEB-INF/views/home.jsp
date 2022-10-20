<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
   <head>
      <title>Magazzino</title>
   </head>
   <body style="text-align: center" bgcolor="#7fffd4" topmargin="200px">

      <h1 style="color: blue">Benvenuto in Magazzino</h1>


      <p style="color: red">${error}</p>

      <p style="font-family:Comic Sans MS" >
         <a href="#" onclick="document.getElementById('listP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden')">Lista Prodotti</a> |
         <a href="#" onclick="document.getElementById('infoP').removeAttribute('hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden')">Dettaglio Prodotto</a> |
         <a href="#" onclick="document.getElementById('newP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden')">Nuovo Prodotto</a> |
         <a href="#" onclick="document.getElementById('editP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden')">Modifica Prodotto</a> |
         <a href="#" onclick="document.getElementById('deleteP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden')">Elimina Prodotto</a> |
         <a href="#" onclick="document.getElementById('findPbyTipo').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden')">Lista Prodotti per Tipo</a> |
         <a href="#" onclick="document.getElementById('findPbyNome_Desc').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden')">Lista Prodotto per Nome |& Desc</a>

      </p>

      <div id="listP" hidden="hidden">
         <form action="./listP" method="get">
            <input type="submit" value="Conferma">
         </form>
      </div>

      <div id="infoP" hidden="hidden">
         <form action="./infoP" method="get">
            <label for="id">ID:</label>
            <input type="text" name="id" value="">
            <input type="submit" value="Conferma">
         </form>
      </div>

      <div id="newP" hidden="hidden">
         <form action="./newP" method="post">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" value="">
            <label for="tipo">Tipo:</label>
            <input type="text" name="tipo" value="">
            <label for="quantita">Quantità:</label>
            <input type="text" name="quantita" value="">
            <label for="descrizione">Descrizione:</label>
            <input type="text" name="descrizione" value="">
            <input type="submit" value="Conferma">
         </form>
      </div>

      <div id="editP" hidden="hidden">
         <form action="./editP" method="post">
            <label for="id">ID:</label>
            <input type="text" name="id" value="">
            <label for="campo">Campo:</label>
            <input type="text" name="campo" value="">
            <label for="valore">Valore:</label>
            <input type="text" name="valore" value="">
            <input type="submit" value="Conferma">
         </form>
      </div>

      <div id="deleteP" hidden="hidden">
         <form action="./deleteP" method="get">
            <label for="id">ID:</label>
            <input type="text" name="id" value="">
            <input type="submit" value="Conferma">
         </form>
      </div>

      <div id="findPbyTipo" hidden="hidden">
         <form action="./findPbyTipo" method="get">
            <label for="tipo">Tipo:</label>
            <input type="text" name="tipo" value="">
            <input type="submit" value="Conferma">
         </form>
      </div>

      <div id="findPbyNome_Desc" hidden="hidden">
         <form action="./findPbyNome_Desc" method="get">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" value="">
            <label for="descrizione">Descrizione:</label>
            <input type="text" name="descrizione" value="">
            <input type="submit" value="Conferma">
         </form>
      </div>

   </body>
</html>