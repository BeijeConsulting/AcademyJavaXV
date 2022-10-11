<%--
  Created by IntelliJ IDEA.
  User: emanu
  Date: 07/10/2022
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList" %>
<%@page import="it.beije.hopper.web.beans.*" %>

<% ArrayList<Order> ordini = (ArrayList) request.getAttribute("Ordini"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>

<strong><a>Show Orders</a></strong>
<p style="color: forestgreen">
    <%
        String successo = (String) request.getAttribute("successo");
        if (successo != null) {
            out.print(successo);
        }
    %>
</p>
<table cellspacing="2" cellpadding="2">


    <tr>
        <th>Date</th>
        <th>Amount</th>
        <th>Promo</th>
        <th>Items</th>
    </tr>
    <%
        // Iterating through subjectList

        if (request.getAttribute("Ordini") != null) {


            for (Order order : ordini) {
    %>
    <tr>
        <td><%=order.getDatetime()%>
        </td>
        <td><%=String.format("%.2f", order.getAmount()) + "$"%>
        </td>
        <td><% if (order.getPromo() != null) out.print(order.getPromo());
        else out.print("Nessuna promo applicata"); %>
        </td>
        <td> <a name="<%=order.getId()%>" href="itemDetails.jps"> <% if (order.getItems() != null) {
            System.out.println(order.getItems().toString());
            out.print("view Item details");
            session.setAttribute("Items", order.getItems());
        }%>
        </a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
