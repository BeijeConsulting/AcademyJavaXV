<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
   <head>
      <title>Magazzino</title>
   </head>
   <body style="text-align: center" bgcolor="#7fffd4" topmargin="200px">

      <h1 style="color: blue">Benvenuto in Magazzino</h1>


      <p style="color: red">${errore}</p>

         <form action="./listP" method="get">
            <input type="submit" value="Lista Prodotti">
         </form>
         <form action="./infoP" method="get">
            <input type="text" name="id" value="id">
            <input type="submit" value="Dettaglio Prodotto">
         </form>
         <form action="./newP" method="post">
            <input type="text" name="nome" value="nome">
            <input type="text" name="tipo" value="tipo">
            <input type="text" name="quantita" value="quantita">
            <input type="text" name="descrizione" value="descrizione">
            <input type="submit" value="Inserisci Prodotto">
         </form>
         <form action="./editP" method="post">
            <input type="text" name="id" value="id">
            <input type="text" name="campo" value="campo">
            <input type="text" name="valore" value="valore">
            <input type="submit" value="Modifica Prodotto">
         </form>
         <form action="./deleteP" method="get">
            <input type="text" name="id" value="id">
            <input type="submit" value="Elimina Prodotto">
         </form>
         <form action="./findPbyTipo" method="get">
            <input type="text" name="tipo" value="tipo">
            <input type="submit" value="Lista Prodotti(tipo)">
         </form>
         <form action="./findPbyNome_Desc" method="get">
            <input type="text" name="nome" value="nome">
            <input type="text" name="descrizione" value="descrizione">
            <input type="submit" value="Lista Prodotti(nome o/e desc)">
         </form>



   </body>
</html>