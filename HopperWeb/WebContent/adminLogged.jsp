<%--
  Created by IntelliJ IDEA.
  User: Raffaele
  Date: 10/10/2022
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="it.beije.hopper.web.Ecommerce" %>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.hopper.web.Product" %>
<%@ page import="it.beije.hopper.web.Order" %>
<%
    String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    String benvenuto = "Complimenti "+ fname +"! Hai effettuato l'accesso";
    List<Product> listaP = Ecommerce.visualizzaProdotti();
    List<Order> listaO = Ecommerce.visualizzaOrdini();
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
<div>
    <table>
        <tr>
            <th>
                PRODOTTI
            </th>
            <th>
                ORDINI
            </th>
        </tr>
        <tr>
            <td style="border-style: solid">
                <% for (Product p: listaP) {
                out.print(p+"<br>");} %>
            </td>
            <td style="border-style: solid">
                <% for (Order o: listaO) {
                out.print(o+"<br>");} %>
            </td>
        </tr>
    </table>
</div>
<div>
    <table>
        <tr><td><a href="#"  onclick="win = window.open('newProduct.html', 'Inserisci Prodotto', 'location=yes,width=400,height=400')"> Inserisci nuovo prodotto </a></td></tr>
        <tr><td><a href="#"  onclick="win = window.open('deleteProduct.html', 'Elimina Prodotto', 'location=yes,width=400,height=400')"> Elimina prodotto </a></td></tr>
    </table>
</div>
</body>
</html>
