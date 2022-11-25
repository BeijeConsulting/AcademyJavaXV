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
<h2> Pagina che restituisce il dettaglio del prodotto tramite id, nome o descrizione (JS) </h2>

  <div>
      <h3>Lista di prodotti</h3>

    <ul id="list">
<%--      <c:forEach var="product" items="${products}" >--%>
<%--          <li>${product.name} - ${product.id}</li>--%>
<%--      </c:forEach>--%>
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

        <div>
            <label for="productname">Product Name:</label>
            <input type="text" id="productname" name="productname"><br>
            <input type="submit" value="Submit" onclick="productByName()">
        </div>
        <br>
        <div>
            <label for="productDesc">Product description:</label>
            <input type="text" id="productDesc" name="productDesc"><br>
            <input type="submit" value="Submit" onclick="productByDesc()">
        </div>
        <br>
        <div>
            <label for="productId">Product id:</label>
            <input type="text" id="productId" name="productId"><br>
            <input type="submit" value="Submit" onclick="productById()">
        </div>
        <br>




    </div>

    <div id="productFound">

    </div>


<script>


    function productById( productId ){
        let newUrl = "http://localhost:8080/Magazzino_war_exploded/api/product/"
        newUrl += document.getElementById("productId").value
        console.log("new Url: " + newUrl)
        fetch(newUrl).then(response => response.json())
            .then( data => {
                let productDiv = document.getElementById("productFound");
                console.log("DATA: ", data);
                productDiv.innerHTML =
                    '<div>'+
                    '<h3>'+ data.name+'</h3>'+
                    '<div>'+ data.id +'</div>'+
                    '<div>'+ data.description +'</div>'+
                    '<div>'+ data.quantity +'</div>'+
                    '<div>'+ data.type +'</div>'
                    +'</h4>'
            })
    }

    function productByName( ){

        let newUrl = "http://localhost:8080/Magazzino_war_exploded/api/productbydesc-name/"+document.getElementById("productname").value+"/s"
        console.log("new Url: " + newUrl)
        fetch(newUrl).then(response => response.json())
            .then( data => {
                let productDiv = document.getElementById("productFound");
                console.log("DATA: ", data);
                productDiv.innerHTML =
                    '<div>'+
                    '<h3>'+ data[0].name+'</h3>'+
                    '<div>'+ data[0].id +'</div>'+
                    '<div>'+ data[0].description +'</div>'+
                    '<div>'+ data[0].quantity +'</div>'+
                    '<div>'+ data[0].type +'</div>'
                    +'</h4>'
            })
    }

    function productByDesc( ){

        let newUrl = "http://localhost:8080/Magazzino_war_exploded/api/productbydesc-name/s/"+document.getElementById("productDesc").value
        console.log("new Url: " + newUrl)
        fetch(newUrl).then(response => response.json())
            .then( data => {
                let productDiv = document.getElementById("productFound");
                console.log("DATA: ", data);
                productDiv.innerHTML =
                    '<div>'+
                    '<h3>'+ data[0].name+'</h3>'+
                    '<div>'+ data[0].id +'</div>'+
                    '<div>'+ data[0].description +'</div>'+
                    '<div>'+ data[0].quantity +'</div>'+
                    '<div>'+ data[0].type +'</div>'
                    +'</h4>'
            })
    }



</script>


<hr>


</body>
</html>
