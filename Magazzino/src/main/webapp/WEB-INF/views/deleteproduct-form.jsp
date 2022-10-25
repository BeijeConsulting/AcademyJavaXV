<%--
  Created by IntelliJ IDEA.
  User: Michael Angelo
  Date: 20/10/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>


</head>
<body>
<%--<title>${product.name}</title>--%>
<h2> Pagina che restituisce il dettaglio del prodotto tramite id - FORM </h2>

  <div>
      <h3>Lista di prodotti</h3>
    <ul>
      <c:forEach var="product" items="${products}" >
          <li>${product.name} - ${product.id}</li>
      </c:forEach>
    </ul>

  </div>
    <div>
      <h2>Modify product</h2>
      <form:form action="./deleteproduct" modelAttribute="product" method="POST">
        <c:forEach var="productL" items="${products}" >
          ${productL} - <form:radiobutton name="id" path="id" value="${productL.id}" />
          <br>
        </c:forEach>

        <br><br>
        <input type="submit" value="Submit"/>
      </form:form>
    </div>


<hr>


</body>
</html>
