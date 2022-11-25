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
<h2> Pagina che restituisce il dettaglio del prodotto tramite id o Nome (JS) </h2>

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
        <script>
            // let productId = -9;

            let urlById = "http://localhost:8080/Magazzino_war_exploded/api/product/"
            function getData( productId ){

                console.log("value: ", document.getElementById('productId').value)
                // urlById += document.getElementById('productId').value
                console.log("new Url: " , urlById)
                fetch(urlById)
                    .then((response) => response.json())
                    .then((json) => console.log(json));

            }

        </script>

        <div>
            <label for="productname">Product Name:</label>
            <input type="text" id="productname" name="productname"><br>
            <input type="submit" value="Submit" onclick="newProduct()">
        </div>
        <br><br>
        <div>
            <label for="type">Product type:</label>
            <input type="text" id="type" name="lname"><br>
            <input type="submit" value="Submit" onclick="newProduct()">
        </div>



    </div>





<hr>


</body>
</html>
