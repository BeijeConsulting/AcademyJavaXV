<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Prodotti</title>
</head>
<style>
    #idproduct {
        background-color: white;
    }
</style>

<body>

    <body style="background-color:powderblue;">


        <table id="table" border="2">
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Quantity</th>
                <th>Description</th>
            </tr>
            <tr>
                <td id="nome"></td>
                <td id="tipologia"></td>
                <td id="quantita"></td>
                <td id="descrizione"></td>

            </tr>

        </table>

        <br><br>

        <script>

            fetch('http://localhost:8080/Magazzino/prodotto/get')
                .then(response => response.json())
                .then(data => {
                    for (let i = 0; i < data.length; i++) {
                        document.getElementById('nome').innerHTML += data[i].nome + "</br>";
                        document.getElementById('tipologia').innerHTML += data[i].tipologia + "</br>";
                        document.getElementById('quantita').innerHTML += data[i].quantita + "</br>";
                        document.getElementById('descrizione').innerHTML += data[i].descrizione + "</br>";
                    }
                })



            function getByid() {
                var id = document.getElementById('idGet').value;
                var url = 'http://localhost:8080/Magazzino/prodotto/byid/' + id;
                fetch(url)
                    .then(response => response.json())
                    .then(data => {
                        document.getElementById('resultid').innerHTML = JSON.stringify(data);
                    })
            }

            function addProduct() {

                fetch('http://localhost:8080/Magazzino/prodotto/insert', {
                    method: 'POST',
                    body: JSON.stringify({
                        nome: document.getElementById('nome').value,
                        tipologia: document.getElementById('tipologia').value,
                        quantita: document.getElementById('quantita').value,
                        descrizione: document.getElementById('descrizione').value,
                    }),
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8',
                    },
                })
                    .then((response) => response.json())
                    .then((json) => console.log(json));
            }

            function updateProduct() {
                console.log(document.getElementById('nomeUpdate').value)
                var id = document.getElementById('idUpdate').value;
                var url = 'http://localhost:8080/Magazzino/prodotto/update/' + id;
                fetch(url, {
                    method: 'PUT',
                    body: JSON.stringify({
                        id:id,
                        nome: document.getElementById('nomeUpdate').value,
                        tipologia: document.getElementById('tipologiaUpdate').value,
                        quantita: document.getElementById('quantitaUpdate').value,
                        descrizione: document.getElementById('descrizioneUpdate').value,
                    }),
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8',
                    },
                })
                    .then((response) => response.json())
                    .then((json) => console.log(json));
            }


        </script>







        <div id="getById">
            <label for="nome">Inserire id prodotto da cercare:</label><br>
            <input type="text" id="idGet" value="">
            <button onclick="getByid()">Submit</button>

        </div>

        <div id="idproduct">
            <p id='resultid'></p>
        </div>

        <br><br>
        <div id='insert'>
            <label>Inserire dettagli del prodotto da aggiungere</label><br>
            <label for="nome">Nome prodotto:</label><br>
            <input type="text" id="nome" value=""><br>
            <label for="tipologia">Tipologia prodotto:</label><br>
            <input type="text" id="tipologia" value=""><br>
            <label for="quantita">Quantita' prodotto:</label><br>
            <input type="text" id="quantita" value=""><br>
            <label for="descrizione">Descrizione prodotto:</label><br>
            <input type="text" id="descrizione" value=""><br><br>
            <button onclick="addProduct()">Submit</button>
        </div>

        <div>
            <label for="nome">Inserire id prodotto da modificare:</label><br>
            <input type="text" id="idUpdate" value=""><br>
            <label for="nome">Nome prodotto:</label><br>
            <input type="text" id="nomeUpdate" value=""><br>
            <label for="tipologia">Tipologia prodotto:</label><br>
            <input type="text" id="tipologiaUpdate" value=""><br>
            <label for="quantita">Quantita' prodotto:</label><br>
            <input type="text" id="quantitaUpdate" value=""><br>
            <label for="descrizione">Descrizione prodotto:</label><br>
            <input type="text" id="descrizioneUpdate" value=""><br><br>
            <button onclick="updateProduct()">update</button>
        </div>

        <div id="getById">
            <label for="nome">Inserire id prodotto da eliminare:</label><br>
            <input type="text" id="idDelete" value="">
            <button onclick="deleteByid()">Submit</button>

        </div>

    </body>

</html>