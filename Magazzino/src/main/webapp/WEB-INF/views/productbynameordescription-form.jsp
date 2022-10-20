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
<h2> Pagina che restituisce la lista di tutti i prodotti di una specifica tipologia </h2>

  <div>
      <h3>Lista di prodotti (Change with --> list of types)</h3>
    <ul>
      <c:forEach var="product" items="${products}" >
          <li>${product.id} - ${product.name} -  ${product.description} - </li>
      </c:forEach>
    </ul>

  </div>
    <div>
      <form:form action="./productbynameordescription" modelAttribute="product" method="POST">
      Product Name: <form:input path="name"/>
      <br><br>
      Product Name: <form:input path="description"/>
      <br><br>
      <input type="submit" value="Submit"/>
      </form:form>
    </div>


<hr>


</body>
</html>
