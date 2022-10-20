<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body  style="text-align: center" topmargin="200px">
<h1>PRODOTTI PER TIPO</h1><br>

<table style="margin: auto">
    
    
    <tr>
        <td style="border-style: solid">
            <c:forEach items="${product}" var="product">
                ${product} <br>
            </c:forEach>
        </td>
    </tr>
</table>