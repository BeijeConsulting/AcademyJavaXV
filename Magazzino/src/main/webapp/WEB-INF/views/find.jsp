<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./prodotti_by_tipologia" method="get">
    <label for="tipologia">Scegli la tipologia che ti interessa:</label>
    <input list="tipologie" name="tipologia" id="tipologia">
    <datalist id="tipologie">
        <c:forEach items="${ProdottoLista}" var="prodotto">
            <option value=${prodotto.tipologia}></option>
        </c:forEach>
    </datalist>
    <input type="submit">
</form>

<form action="./prodotti_by_nome_or_descrizione" method="get">
    <label for="tipologia">cerca per nome o/e descrizione che ti interessa:</label>
    <input list="nomi" name="nome" id="nome">
    <datalist id="nomi">
        <c:forEach items="${ProdottoLista}" var="prodotto">
            <option value=${prodotto.nome}></option>
        </c:forEach>
    </datalist>
    <input list="descrizioni" name="descrizione" id="descrizione">
    <datalist id="descrizioni">
        <jsp:useBean id="ProdottoLista" scope="request" type="java.util.List"/>
        <c:forEach items="${ProdottoLista}" var="prodotto">
            <option value=${prodotto.descrizione}></option>
        </c:forEach>
    </datalist>
    <input type="submit">
</form>
</body>
</html>
