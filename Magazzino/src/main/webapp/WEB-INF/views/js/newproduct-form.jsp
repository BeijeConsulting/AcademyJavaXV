<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 20/10/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>


</head>
<body>
<%--<title>${product.name}</title>--%>
<h2> Pagina per la creazione di un nuovo prodotto (JS) </h2>


    <div>
      <h3>Lista di prodotti</h3>

      <ul id="list">

      </ul>


      <script>
        const url = "http://localhost:8080/Magazzino_war_exploded/api/products"
        let ul = document.getElementById("list");
        fetch(url).then( response => response.json()).then( data => {
          data.forEach( function(object) {
            let li = document.createElement('li')
            li.innerHTML = object.name + ' - ' + object.id
            ul.append(li);

          })
        })

      </script>
    </div>


    <div>
      <h3>New Product:</h3>
      <div>
        <label for="productname">Product Name:</label>
        <input type="text" id="productname" name="productname"><br><br>

        <label for="type">Product type:</label>
        <input type="text" id="type" name="lname"><br><br>

        <label for="quantity">Product quantity:</label>
        <input type="text" id="quantity" name="quantity"><br><br>

        <label for="description">Product description:</label>
        <input type="text" id="description" name="description"><br><br>
        <input type="submit" value="Submit" onclick="newProduct()">
      </div>

    </div>
    <script>
      function newProduct(){
        console.log("product Name: " , document.getElementById("productname").value);


        fetch('http://localhost:8080/Magazzino_war_exploded/api/product', {
          method: 'POST',
          body: JSON.stringify({
            name: document.getElementById("productname").value,
            type: document.getElementById("quantity").value,
            quantity: Number(document.getElementById("quantity").value),
            description: document.getElementById("description").value
          }),
          headers: {
            'Content-type': 'application/json; charset=UTF-8',
          },
        })
        .then((response) => response.json())
        .then((json) => console.log(json));



      }
    </script>



<hr>


</body>
</html>
