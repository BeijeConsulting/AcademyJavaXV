<%--
  Created by IntelliJ IDEA.
  User: antoniocirillo1
  Date: 25/11/2022
  Time: 12:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>AA</title>
</head>
<body>
<button onclick="listProducts()">All products list</button>
<button onclick="listSpedizioni()">All spedizioni list</button>

<br><br><br>
<form action="./addprodottoCh" method="post">
    <label for="name">Nome:</label><br>
    <input type="text" name="name" id="name" value=""><br>
    <label for="typology">Tipologia:</label><br>
    <input type="text" name="typology" id="typology" value=""><br>
    <label for="quantity">Quantità:</label><br>
    <input type="text" name="quantity" id="quantity" value=""><br>
    <label for="description">Descrizione:</label><br>
    <input type="text" name="description" id="description" value="">
    <input type="submit" value="Inserisci Prodotto"
           onclick="addProduct(document.getElementById('name').value, document.getElementById('typology').value, document.getElementById('quantity').value, document.getElementById('description').value)">
</form>
${product}
<br><br><br><br><br><br>
<form action="./searchProductCh" method="post">
    <label for="id">ID:</label><br>
    <input type="text" name="id" id="id" value=""><br>
    <input type="submit" value="Ricerca prodotto">
</form>
<form action="./deleteProduct" method="post">
    <label for="id">ID:</label><br>
    <input type="text" name="id" id="idDelete" value=""><br>
    <input type="submit" onclick="deleteByID(document.getElementById('idDelete').value)" value="Elimina prodotto">
</form>
<script>
    function listProducts() {
        fetch('http://localhost:8080/Magazzino/rest/listAllProducts')
            .then(response => response.json())
            .then(json => console.log(json))
    }


    function listSpedizioni() {
        fetch('http://localhost:8080/Magazzino/rest/findAllSpedizioni')
            .then(response => response.json())
            .then(json => console.log(json))
    }
</script>
<script>
    function deleteByID(idDelete) {
        fetch('http://localhost:8080/Magazzino/rest/deleteProduct/${idDelete}', {
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => console.log(json));

    }
    function addProduct(name, typology, quantity, description) {
        fetch('http://localhost:8080/Magazzino/rest/addProduct', {
            method: 'POST',
            body: JSON.stringify({
                name: name,
                typology: typology,
                quantity: quantity,
                description: description,
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => console.log(json));
    }
    fetch('http://localhost:8080/Magazzino/rest/searchProduct/${id}')
        .then(response => response.json())
        .then(json => console.log(json))
</script>


<br>
</body>
</html>
