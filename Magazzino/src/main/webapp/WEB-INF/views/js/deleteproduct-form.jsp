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
<h2> Pagina che per la cancellazione di un prodotto </h2>

<div>
  <h3>Lista di prodotti</h3>

  <ul id="list">
    <%--      <c:forEach var="product" items="${products}" >--%>
    <%--          <li>${product.name} - ${product.id}</li>--%>
    <%--      </c:forEach>--%>
  </ul>


  <script>
    const url = "http://localhost:8080/Magazzino_war_exploded/api/products"
    loadData();
    function loadData(){
      let ul = document.getElementById("list");
      fetch(url).then( response => response.json()).then( data => {
        data.forEach( function(object) {
          let li = document.createElement('li')
          li.innerHTML = object.name + ' - ' + object.id
          ul.append(li);

        })
      })
    }



  </script>
</div>
<div>

  <div>
    <label for="productId">Product id:</label>
    <input type="text" id="productId" name="productId"><br>
    <input type="submit" value="Submit" onclick="deleteById()">
  </div>
  <br>

<script>
  function deleteByName(){
    let url = "http://localhost:8080/Magazzino_war_exploded/api/product/"+ document.getElementById("productId")
    fetch(url, {
      method: 'DELETE',
    });
  }


</script>


</div>

<hr>


</body>
</html>
