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
         <a href="#" onclick="document.getElementById('listP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Lista Prodotti</a> |
         <a href="#" onclick="document.getElementById('infoP').removeAttribute('hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Dettaglio Prodotto</a> |
         <a href="#" onclick="document.getElementById('newP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Nuovo Prodotto</a> |
         <a href="#" onclick="document.getElementById('editP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Modifica Prodotto</a> |
         <a href="#" onclick="document.getElementById('deleteP').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Elimina Prodotto</a> |
         <a href="#" onclick="document.getElementById('findPbyTipo').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Lista Prodotti per Tipo</a> |
         <a href="#" onclick="document.getElementById('findPbyNome_Desc').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Lista Prodotto per Nome |& Desc</a>
         <br>
         <a href="#" onclick="document.getElementById('listS').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden');document.getElementById('infoS').setAttribute('hidden','hidden')">Lista Spedizioni</a>  |
         <a href="#" onclick="document.getElementById('infoS').removeAttribute('hidden');document.getElementById('infoP').setAttribute('hidden','hidden');document.getElementById('newP').setAttribute('hidden','hidden');document.getElementById('findPbyNome_Desc').setAttribute('hidden','hidden');document.getElementById('editP').setAttribute('hidden','hidden');document.getElementById('deleteP').setAttribute('hidden','hidden');document.getElementById('findPbyTipo').setAttribute('hidden','hidden');document.getElementById('listS').setAttribute('hidden','hidden');document.getElementById('listP').setAttribute('hidden','hidden')">Dettaglio Spedizione</a>  |
      </p>

      <div id="listP" hidden="hidden">
         <form>
            <input type="submit" value="Conferma" onclick="getListaP()">
         </form>
      </div>

      <div id="infoP" hidden="hidden">
         <form>
            <label for="id">ID:</label>
            <input type="text" name="id" id="inputP" value="">
            <input type="submit" value="Conferma" onclick="getInfoP(document.getElementById('inputP').value)">
         </form>
      </div>

      <div id="newP" hidden="hidden">
         <form>
            <label for="nome">Nome:</label>
            <input type="text" id="newNome" name="nome" value="">
            <label for="tipo">Tipo:</label>
            <input type="text" id="newTipo" name="tipo" value="">
            <label for="quantita">Quantità:</label>
            <input type="text" id="newQuantita" name="quantita" value="">
            <label for="descrizione">Descrizione:</label>
            <input type="text" id="newDescrizione" name="descrizione" value="">
            <input type="submit" value="Conferma" onclick="postNewP(document.getElementById('newNome').value, document.getElementById('newTipo').value,
                                                            document.getElementById('newQuantita').value, document.getElementById('newDescrizione').value)">
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
         <form>
            <label for="id">ID:</label>
            <input type="text" id="delete" name="id" value="">
            <input type="submit" value="Conferma" onclick="deleteP(document.getElementById('delete').value)">
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

      <div id="listS" hidden="hidden">
         <form>
            <input type="submit" value="Conferma" onclick="getListaS()">
         </form>
      </div>

      <div id="infoS" hidden="hidden">
         <form>
            <label for="id">ID:</label>
            <input type="text" name="id" id="inputS" value="">
            <input type="submit" value="Conferma" onclick="getInfoS(document.getElementById('inputS').value)">
         </form>
      </div>

      <div id="display">
      </div>

   <script>
      function getListaP(){
         let products
         fetch('http://localhost:8080/Magazzino_war/restListP')
            .then(response => response.json())
            .then(json => products = json)
            .then(show => showProducts(products))

      }

      function getListaS(){
         let shipments
         fetch('http://localhost:8080/Magazzino_war/restListS')
                 .then(response => response.json())
                 .then(json => shipments = json)
                 .then(show => showShipments(shipments))
      }

      function getInfoP(id){
         console.log(id)
         let products
         fetch('http://localhost:8080/Magazzino_war/restInfoP/'+id.toString())
                 .then(response => response.json())
                 .then(json => products = json)
                 .then(show => showProducts(products))
      }

      function getInfoS(id){
         console.log(id)
         let details
         fetch('http://localhost:8080/Magazzino_war/restInfoS/'+id.toString())
                 .then(response => response.json())
                 .then(json => details = json)
                 .then(show => showShipmentsDetails(details))
      }

      function postNewP(nome, tipo, quantita, descrizione){
         console.log(nome)
         console.log(tipo)
         console.log(quantita)
         console.log(descrizione)
         let newProduct
         fetch('http://localhost:8080/Magazzino_war/restNewP', {
            method: 'POST', // or 'PUT'
            headers: {
               'Content-Type': 'application/json',
            },
            body: JSON.stringify({
               nome: nome,
               tipo: tipo,
               quantita: quantita,
               descrizione: descrizione
            }),
         })
                 .then((response) => response.json())
                 .then(json => newProduct = json)
                 .then(show => showProducts(newProduct))
      }

      function deleteP(id){
         let deletedProduct
         fetch('http://localhost:8080/Magazzino_war/restDeleteP/'+id, {
            method: 'DELETE', // or 'PUT'
            headers: {
               'Content-Type': 'application/json',
            },
            body: JSON.stringify({
               id: id
            }),
         })
                 .then((response) => response.json())
                 .then(json => deletedProduct = json)
                 .then(show => showProducts(deletedProduct))
      }


      function showProducts(products){
         let count = 1;

         let stampa = "<table style='text-align: center'>"
         stampa += "<tr> <td></td> <td>NAME</td> <td>TYPOLOGY</td> <td>QUANTITY</td>  <td>DESCRIPTION</td> </tr>"
         if(products.length >1){
            products.forEach(el => {
               stampa += "<tr> <td>" + count + "</td> <td>"+el.nome+"</td> <td>"
                       +el.tipo +"</td> <td>"+el.quantita+"</td>  <td>"+el.descrizione+"</td> </tr>";
               count++;
            });
         }   else{
            stampa += "<tr> <td>" + count + "</td> <td>"+products.nome+"</td> <td>"
                    +products.tipo +"</td> <td>"+products.quantita+"</td>  <td>"+products.descrizione+"</td> </tr>";
         }


         stampa += "</table>";

         document.getElementById('display').innerHTML = stampa
      }

      function showShipments(shipments){
         let count = 1;

         let stampa = "<table style='text-align: center'>"
         stampa += "<tr> <td></td> <td>CODICE</td> <td>DESTINATARIO</td> <td>INDIRIZZO</td>  <td>DATA SPEDIZIONE</td> <td>DATA RICEZIONE</td> </tr>"

            shipments.forEach(el => {
               stampa += "<tr> <td>" + count + "</td> <td>"+ el.codice+"</td> <td>"
                       +el.destinatario +"</td> <td>"+el.indirizzo+"</td>  <td>"+el.data_spedizione+"</td> <td>"+el.data_ricezione+"</td></tr>";
               count++;
            });




         stampa += "</table>";

         document.getElementById('display').innerHTML = stampa
      }

      function showShipmentsDetails(details){
         let count = 1;

         let stampa = "<table style='text-align: center'>"
         stampa += "<tr> <td></td> <td>CODICE</td> <td>SPEDIZIONE</td> <td>RICEZIONE</td><td>DESTINATARIO</td> <td>INDIRIZZO</td></tr>"


               stampa += "<tr> <td>" + count + "</td> <td>"+ details.codice+"</td> <td>"+details.data_spedizione +"</td> <td>"+details.data_ricezione+"</td>" +
                       "<td>"+details.destinatario+"</td><td>"+details.indirizzo+"</td> </tr>";

         stampa += "</table >";
         stampa += "<table style='text-align: center'><tr> <td> DETTAGLIO ORDINE: </td></tr><tr></tr>+" +
                 "<tr><td></td><td>ID PRODOTTO</td><td>QUANTITA'</td></tr>"

         details["contenuto"].forEach(el => {
            stampa += "<tr> <td>" + count + "</td> <td>"+ el.id_prodotto+"</td> <td>" +el.quantita +"</td></tr>";
            count++;
         });

         stampa += "</table>";
         document.getElementById('display').innerHTML = stampa
      }
   </script>

   </body>
</html>