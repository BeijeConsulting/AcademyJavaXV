<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotti</title>
</head>
<body>
<body style="background-color:powderblue;">





<div id='get'> </div>
<script>
fetch('prodotto/get')	
.then(response => response.json())
.then(data => {
    document.getElementById('get').innerHTML=JSON.stringify(data);
    console.log(data);
})
</script>

<script>
function addProduct(){

    document.getElementsByName('nome')
    fetch('prodotto/get', {
        method: 'POST',
        body: JSON.stringify({
        title: document.getElementsByName('nome'),
        body: 'bar',
        userId: 1,
    }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
  .then((response) => response.json())
  .then((json) => console.log(json));
}
</script>


<div id='insert'>

<label for="nome">Nome prodotto:</label><br>
  <input type="text" name="nome" value=""><br>
  <label for="tipologia">Tipologia prodotto:</label><br>
  <input type="text" name="tipologia" value=""><br>
  <label for="quantita">Quantità prodotto:</label><br>
  <input type="text" name="quantita" value=""><br>
  <label for="descrizione">Descrizione prodotto:</label><br>
  <input type="text" name="descrizione" value=""><br><br>
  <button onclick="addProduct()"></button>
</div>



<h1></h1>
<form action="back">
	<button>Torna alla home</button>
</form>
</body>
</html>