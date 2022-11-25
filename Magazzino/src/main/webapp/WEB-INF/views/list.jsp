<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista Prodotti</title>
</head>
<body>
<h4>${message}</h4>

<h3>Lista prodotti:</h3>
<table cellspacing="2" cellpadding="2">
<tr>
    <th>Id</th>
    <th>Nome</th>
    <th>tipologia</th>
    <th>Descrizione</th>
    <th>Quantita</th>
</tr>
<jsp:useBean id="ProdottoLista" scope="request" type="java.util.List"/>
<c:forEach items="${ProdottoLista}" var="prodotto">
        <tr>
            <td>${prodotto.id}</td>

            <td>${prodotto.nome}</td>

            <td> ${prodotto.tipologia}</td>

            <td>${prodotto.quantita}</td>

            <td>${prodotto.descrizione}</td>
            <td> <a href="prodotto_by_id?id=${prodotto.id}"> <%
            out.print("\t Vedi dettaglio prodotto");
            %> </td>
            <td> <a href="update_prodotto?id=${prodotto.id}"> <%
            out.print("\t Aggiorna prodotto");
            %> </td>
            <td> <a href="delete_prodotto?id=${prodotto.id}"> <%
            out.print("\t Cancella prodotto");
            %> </td>
        </tr>

</c:forEach>
</table>

<a href="add_prodotto"> <%
            out.print("\t Crea prodotto");
%>
    <a href="find"> <%
            out.print("\t Cerca");
%>

<script>
    fetch('api/prodotti')
        .then((response) => response.json())
        .then((json) => console.log(json[0]))
        .then((json) => {testo = json[0]})
        .then(() => display.innerHTML = testo)
</script>
</body>
</html>
