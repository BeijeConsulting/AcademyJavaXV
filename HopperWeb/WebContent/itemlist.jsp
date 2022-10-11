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
    <title>E-commerce brutto</title>
</head>
<body>
<%@page import="java.util.ArrayList" %>
<%@page import="it.beije.hopper.web.beans.*" %>
<%@page import="java.util.Iterator" %>

<% ArrayList<Product> prodList = (ArrayList) session.getAttribute("ProdList"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>

<strong><a>Show Product Details</a></strong>
<br></br>
<p style="color: red">
    <%
        String error = (String) session.getAttribute("errore");
        if (error != null) {
            out.print(error);
            session.removeAttribute("errore");
        }
    %>
</p>
<form action="./add_ordine" method="post">
    <table cellspacing="2" cellpadding="2">


        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Rating</th>
            <th>Quantity max</th>
        </tr>
        <%
            // Iterating through subjectList

            if (session.getAttribute("ProdList") != null)  // Null check for the object
            {
                Iterator<Product> iterator = prodList.iterator();  // Iterator interface

                while (iterator.hasNext())  // iterate through all the data until the last record
                {
                    Product product = iterator.next();
        %>
        <tr>
            <td><%=product.getName()%>
            </td>
            <td><%=String.format("%.2f", product.getPrice()) + "$"%>
            </td>
            <td><%=product.getDesc()%>
            <td><%=product.getRating()%>
            </td>
            </td>

            <td>
                <% if (product.getQuantity() > 0) { %>
                <input type="number" name="<%=product.getId()%>" min="0" max="<%=product.getQuantity()%>">
                <%} else {%>
                <p style="color: red">
                    <%
                        out.print("Oggetto non disponibile al momento");
                    %>
                </p></td>
            <%}%>
        </tr>
        <%
                }
            }
        %>
    </table>
    <input type="submit">
</form>

</body>
</html>
