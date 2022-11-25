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
  </div>

    <div>
      <h3>New Product:</h3>
      <form action="/action_page.php" method="POST">
        <label for="productname">Product Name:</label>
        <input type="text" id="productname" name="productname"><br><br>

        <label for="type">Product type:</label>
        <input type="text" id="type" name="lname"><br><br>

        <label for="quantity">Product quantity:</label>
        <input type="text" id="quantity" name="quantity"><br><br>

        <label for="description">Product description:</label>
        <input type="text" id="description" name="description"><br><br>
        <input type="submit" value="Submit">
      </form>

    </div>



<hr>


</body>
</html>
