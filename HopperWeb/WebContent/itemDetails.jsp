<%--
  Created by IntelliJ IDEA.
  User: emanu
  Date: 11/10/2022
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dettagli Item</title>
</head>
<body>
<%@page import="java.util.ArrayList" %>
<%@page import="it.beije.hopper.web.beans.*" %>
<%@page import="java.util.Iterator" %>

<% ArrayList<Item> items = (ArrayList) session.getAttribute("Items"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>

<strong><a>Show order details</a></strong>
<br></br>
    <table cellspacing="2" cellpadding="2">


        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Quantity max</th>
        </tr>
        <%
            // Iterating through subjectList

            if (session.getAttribute("Items") != null)  // Null check for the object
            {
                Iterator<Item> iterator = items.iterator();  // Iterator interface

                while (iterator.hasNext())  // iterate through all the data until the last record
                {
                    Item item = iterator.next();
        %>
        <tr>
            <td><%=item.getName()%>
            </td>
            <td><%=String.format( "%.2f", item.getPrice()) + "$"%>
            </td>
            <td><%=item.getDesc()%>
            </td>
            <td><%=item.getQuantity()%>
            </td>
            </td>

        </tr>
        <%
                }
            }
        %>
    </table>


</body>
</html>
