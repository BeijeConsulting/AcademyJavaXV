<%@ page import="java.util.ArrayList" %>
<%@ page import="it.beije.hopper.ecommerceMod.models.Order" %>
<%@ page import="it.beije.hopper.ecommerceMod.EcommerceJPA" %><%--
  Created by IntelliJ IDEA.
  User: toni-
  Date: 11/10/2022
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    int id = (int) session.getAttribute("id");
    ArrayList<Order> orders = (ArrayList<Order>) EcommerceJPA.getAllUserOrders(id);%>

<style>
    th, td {
        border: 1px solid black;
        border-radius: 10px;
    }
</style>
<table>
    <%
        for (int i = 0; i < orders.size(); i++) {
//            out.println(orders.get(i).getId());
//            out.println(orders.get(i).getDatetime());
//            out.println(orders.get(i).getAmount());
    %>
    <tr>
        <th>ID Ordine</th>
        <th>Data</th>
        <th>Totale</th>
        <th>Seleziona</th>
    </tr>
    <tr>
        <form action="orderView.jsp" method="post">{<input type="hidden" name="idOrder" value=${orders.get(i).getId()}><td><%=orders.get(i).getId()%>  </form>
        </td>
        <td><%=orders.get(i).getDatetime()%>
        </td>
        <td><%=orders.get(i).getAmount()%>
        </td>
        <td>
            <a href="orderView.jsp">Visualizza</a>
        </td>
    </tr>

    <%
        }
    %>

</table>
</body>
</html>
