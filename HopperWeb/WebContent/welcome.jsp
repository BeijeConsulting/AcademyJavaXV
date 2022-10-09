<%@page import="java.time.LocalDateTime"%>
<%@ page import="jakarta.persistence.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<%
//String fname = request.getParameter("fname");
//String lname = request.getParameter("lname");

String fname = (String) session.getAttribute("fname");
String lname = (String) session.getAttribute("lname");

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    List a = entityManager.createNativeQuery("SELECT * FROM order_items").getResultList();
   // System.out.println(a.size());
   // System.out.println(a);
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();


    entityTransaction.commit();
    entityManager.close();

//System.out.print(fname);
//System.out.print(lname);
int x = 10+5;
String timestamp = LocalDateTime.now().toString();
%>

<strong><%= timestamp %></strong>
<br>
FIRST NAME : <%= fname %><br>
LAST NAME : <%= lname %><br>
LIST : <%= a %>
</body>
</html>