<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Test 20-10-2022</title>
</head>
<body>
<h1>Servizi richiesti</h1>
    <div>

        <h2>Parte 1 Javascript</h2>
        <ul>
            <li><a href="./products-html">Pagina che restituisce la lista di tutti i prodotti</a></li>

            <li><a href="./productbyname-id-html">Pagina che restituisce il dettaglio del prodotto tramite id o nome</a></li>

            <li><a href="./modifyproduct-form"> Pagina per la modifica di un prodotto esistente</a></li>

            <li><a href="./deleteproduct-form"> Pagina per la cancellazione di un prodotto</a></li>

            <li><a href="./productbytype-form">Pagina che restituisce la lista di tutti i prodotti di una specifica
                tipologia</a></li>

            <li><a href="./productbynameordescription-form"> Pagina che restituisce la lista dei prodotti di una ricerca per
                nome e/o descrizione</a></li>

            <li><a href="./newproduct-form-html"> Pagina che inserisce un nuovo prodotto </a></li>

        </ul>


    </div>
    <hr>

<%--      <div>--%>
<%--         <button onclick="getAll()">getAll</button>--%>
<%--&lt;%&ndash;         <button onclick="getById4()">getById4</button>&ndash;%&gt;--%>
<%--         <script>--%>
<%--            function getAll(){--%>
<%--               fetch("http://localhost:8080/Magazzino_war_exploded/api/products")--%>
<%--                       .then(response => response.json())--%>
<%--                       .then(json => console.log(json));--%>
<%--            }--%>
<%--         </script>--%>
<%--      </div>--%>

</body>
</html>