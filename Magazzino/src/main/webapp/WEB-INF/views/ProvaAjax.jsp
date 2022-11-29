<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id='get'> </div>
<!-- <button onclick = "fetch('prodotti')
    .then(response => response.json())
    .then(json => console.log(json)) ">Lista Prodotti</button> -->
    
    <button onclick = "fetch('prodotti')
    .then(response => response.json())
    .then(data => {
        document.getElementById('get').innerHTML=JSON.stringify(data);
        console.log(data);}) ">Lista Prodotti</button>
        
        <br>
        <br>
        
      
        
<!--     <button onclick = "fetch('prodotto/2')
    .then(response => response.json())
    .then(data => {
        document.getElementById('get').innerHTML=JSON.stringify(data);
        console.log(data);}) ">Prodotto 2</button> -->
        
<!-- <div >
  <label>id:</label>
  <input type="text" id="id">
  <button onclick = "fetch('prodotto/{id}',{ 
		 method: 'POST', 
		 body: JSON.stringify({
			 id: document.getElementById('id').value,
			 }),
			 headers: {
				 "Content-type": "application/json; charset=UTF-8"
			 },
		 })
		 .then((response) => response.json())
    .then((json) => console.log(json))">cerca</button>
</div> -->



 <script>
/* function ricercaId()
{
	 fetch('prodotto/{id}',{ 
		 method: 'POST', 
		 body: JSON.stringify({
			 id: document.getElementById("id").value,
			 }),
			 headers: {
				 "Content-type": "application/json; charset=UTF-8"
			 },
		 })
		 .then((response) => response.json())
    .then((json) => console.log(json));
	
 }  */
 
 
 function insertProduct(){				//FUNZIONA
	 fetch('insertprodotto',{
	 method: 'POST',
	 body: JSON.stringify({
		nome: document.getElementById('nome').value,
		tipologia: document.getElementById('tipologia').value,
		quantita: document.getElementById('quantita').value,
		descrizione: document.getElementById('descrizione').value
	 }),
	 headers: {
		 'Content-type':'application/json; charset=UTF-8',
	 },
	 })
	 	.then((response) => response.json())
	 	.then((json) => console.log(json));
	 
 }
 
 function getProduct(){		//FUNZIONA
	 
	 let id=document.getElementById("id").value; 
	 fetch('prodotto/'+id,{	//CREA LA STRINGA DA PASSARE CON L'ENDPOINT
	 method: 'POST',
	 body: JSON.stringify({
		id: document.getElementById('id').value
		
	 }),
	 headers: {
		 'Content-type':'application/json; charset=UTF-8',
	 },
	 })
	 	.then((response) => response.json())
	 	.then((json) => console.log(json));  
	 
 }
 
function putProduct(){		//FUNZIONA
	 
	 let idp=document.getElementById("idp").value; 
	 fetch('prodotto/'+idp,{	
	 method: 'PUT',
	 body: JSON.stringify({
		nome: document.getElementById('nomep').value,
		tipologia: document.getElementById('tipologiap').value,
		quantita: document.getElementById('quantitap').value,
		descrizione: document.getElementById('descrizionep').value
	 }),
	 headers: {
		 'Content-type':'application/json; charset=UTF-8',
	 },
	 })
	 	.then((response) => response.json())
	 	.then((json) => console.log(json));  
	 
 }
 
 
function deleteProduct(){		//FUNZIONA
	 
	 let idd=document.getElementById("idd").value;
	  fetch('prodotto/'+idd,{
	 method: 'DELETE',
	 body: JSON.stringify({
		idd: document.getElementById('id').value
	 }),
	 headers: {
		 'Content-type':'application/json; charset=UTF-8',
	 },
	 })
	 	.then((response) => response.json())
	 	.then((json) => console.log(json)); 
	 
 }
 
 function findByTipologia(){
	 
	 let idt=document.getElementById("idt").value; 
	 fetch('prodotto/tipologia/'+idt,{	
		 method: 'POST',
		 body: JSON.stringify({
			idt: document.getElementById('idt').value
		 }),
		 headers: {
			 'Content-type':'application/json; charset=UTF-8',
		 },
		 })
		 	.then((response) => response.json())
		 	.then((json) => console.log(json));  
	 
 }
 
function findByNomeOrDescrizione(){		
	 
	 let nomef=document.getElementById("nomef").value;
	 let descrizionef=document.getElementById("descrizionef").value;
	  fetch('prodotto/'{
	 method: 'GET',
	 body: JSON.stringify({
		 nomef: document.getElementById('nomef').value,
		 descrizionef: document.getElementById('descrizionef').value
	 }),
	 headers: {
		 'Content-type':'application/json; charset=UTF-8',
	 },
	 })
	 	.then((response) => response.json())
	 	.then((json) => console.log(json)); 
	 
 }
 
</script>


<div id = 'getById'>

<label for = "id">Id prodotto: </label><br>
<input type = "text" id = "id"><br>

<!-- <button onclick = "getProduct()">Cerca prodotto con id</button> -->
<button onclick = "getProduct()">Cerca prodotto con id</button>


</div>

<br>
<br>





<div id = 'deleteById'>

<label for = "idd">Id prodotto: </label><br>
<input type = "text" id = "idd"><br>

<!-- <button onclick = "getProduct()">Cerca prodotto con id</button> -->
<button onclick = "deleteProduct()">elimina prodotto con id</button>

</div>

<br>
<br>

<div id = 'getByTipologia'>

<label for = "idt">Tipologia prodotto: </label><br>
<input type = "text" id = "idt"><br>

<!-- <button onclick = "getProduct()">Cerca prodotto con id</button> -->
<button onclick = "findByTipologia()">Trova prodotti</button>

</div>

<br>
<br>



<div id = 'insert'>

<label for = "nome">Nome prodotto: </label><br>
<input type = "text" id = "nome" value=""><br>
<label for = "tipologia">Tipologia prodotto: </label><br>
<input type = "text" id = "tipologia" value=""><br>
<label for = "quantita">Quantità prodotto: </label><br>
<input type = "text" id = "quantita" value=""><br>
<label for = "descrizione">Descrizione prodotto: </label><br>
<input type = "text" id = "descrizione" value=""><br>
<button onclick = "insertProduct()">Aggiungi prodotto</button> 


</div>

<br>
<br>


<div id = 'update'>

<label for = "idp">Id prodotto: </label><br>
<input type = "text" id = "idp"><br>
<label for = "nome">Nuovo nome prodotto: </label><br>
<input type = "text" id = "nomep" value=""><br>
<label for = "tipologia">Nuova Tipologia prodotto: </label><br>
<input type = "text" id = "tipologiap" value=""><br>
<label for = "quantita">Nuova Quantità prodotto: </label><br>
<input type = "text" id = "quantitap" value=""><br>
<label for = "descrizione">Nuova Descrizione prodotto: </label><br>
<input type = "text" id = "descrizionep" value=""><br>
<button onclick = "putProduct()">Update prodotto</button> 


</div>

<br>
<br>

<div id = 'getByNomeOrDescrizione'>

<label for = "nomef">Nome prodotto: </label><br>
<input type = "text" id = "nomef"><br>
<label for = "descrizionef">Descrizione prodotto: </label><br>
<input type = "text" id = "descrizionef"><br>

<!-- <button onclick = "getProduct()">Cerca prodotto con id</button> -->
<button onclick = "getProduct()">Cerca prodotto con nome e/o descrizione</button>


</div>

    

</body>
</html>