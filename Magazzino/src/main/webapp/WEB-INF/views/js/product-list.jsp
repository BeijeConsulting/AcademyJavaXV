<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 20/10/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>


</head>
<body>
<title>Products</title>
<h3> Pagina che restituisce la lista di tutti i prodotti </h3>
<table id="table" border="1">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Type</th>
        <th>Available quantity</th>
        <th>Description</th>
    </tr>

</table>
<hr>

<script>
    const url = "http://localhost:8080/Magazzino_war_exploded/api/products"

    let table = document.getElementById("table");
    fetch(url).then( response => response.json()).then(data=>
    {
        console.log(data)
        data.forEach( function( object ){
                let tr = document.createElement('tr');
                tr.innerHTML = '<td>'+ object.id+'</td>'+
                    '<td>'+ object.name+'</td>'+
                    '<td>'+ object.type+'</td>'+
                    '<td>'+ object.quantity+'</td>'+
                    '<td>'+ object.description+'</td>'
                table.append(tr);
                // console.log("NEW DATA: " + tr.innerHTML)
            }

        );
    })

</script>



</body>
</html>
