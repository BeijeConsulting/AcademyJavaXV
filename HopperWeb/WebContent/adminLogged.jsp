<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 10/10/2022
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="it.beije.hopper.web.Ecommerce" %>
<%
    String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    String benvenuto = "Complimenti "+ fname +"! Hai effettuato l'accesso";

%>
<html>
<head>
    <title>Benvenuto Admin!!!</title>
</head>
<body>
<div>
    <strong><%= benvenuto %></strong><br>
    FIRST NAME : <%= fname %><br>
    LAST NAME : <%= lname %><br>
</div>
<h2>Ecco l'elenco di operazioni che puoi effettuare: </h2>
<div>
    <table>
        <tr><td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')"> Inserisci nuovo prodotto</a></td></tr>
        <tr><td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')">Elimina prodotto</a></td></tr>
        <tr><td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')">Visualizza elenco prodotti</a></td></tr>
        <tr><td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')">Visualizza ordini</a></td></tr>
    </table>
</div>
</body>
</html>
