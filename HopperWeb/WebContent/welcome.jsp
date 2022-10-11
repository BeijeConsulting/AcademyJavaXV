<%@ page import="java.time.LocalDateTime"%>
<%@ page import="jakarta.persistence.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="it.beije.hopper.web.Product" %>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<%


Integer b = (Integer) session.getAttribute("admin");
String pageAdmin="";
String pageUser="";

//String timestamp = LocalDateTime.now().toString();
%>
<div>
    <%
        if(b != null){
        pageAdmin = "adminLogged.jsp";
        response.sendRedirect(pageAdmin);
    }else{
        pageUser = "normalUserLogged.jsp";
        response.sendRedirect(pageUser);
    }%>
</div>

</body>
</html>