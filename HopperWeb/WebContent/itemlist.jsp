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
<%@page import="java.util.Iterator" %>

<% ArrayList<Product> prodList = (ArrayList) session.getAttribute("ProdList"); %> <%--Assigning ArrayList object containing Employee data to the local object --%>

<strong><a href="<%=request.getContextPath()%>/IteratorExample?type=getDetails">Show Product Details</a></strong>
<br></br>
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
                    Product product = iterator.next(); //assign individual employee record to the employee class object
        %>
        <tr>
            <td><%=product.getName()%>
            </td>
            <td><%=product.getPrice()%>
            </td>
            <td><%=product.getDesc()%>
            <td><%=product.getRating()%>
            </td>
            </td>
            <td><input type="number" name="<%=product.getId()%>" min="0" max="<%=product.getQuantity()%>"></td>

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
