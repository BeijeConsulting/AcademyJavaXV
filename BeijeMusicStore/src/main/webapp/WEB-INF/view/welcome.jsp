<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<h1>LISTA SERVIZI: </h1>

<form action="/action_page.php" method="get">
	<label for="browser">Choose your browser from the list:</label>
	<input list="browsers" name="browser" id="browser">
	<datalist id="browsers">
		<option value="Edge">
		<option value="Firefox">
		<option value="Chrome">
		<option value="Opera">
		<option value="Safari">
	</datalist>
	<input type="submit">
</form>


<a href="artista_by_genere?genere=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce gli ARTISTI tramite il GENERE");
}%>
</a>

<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce l'ALBUM tramite l'ARTISTA");
}%>
</a>

<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce le CANZONI tramite l'ALBUM");
}%>
</a>

<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce le CANZONI tramite l'ARTISTA");
}%>
</a>

<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce gli ALBUM tramite il GENERE");
}%>
</a>

<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce le CANZONI tramite il GENERE");
}%>
</a>


<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce l'ALBUM tramite la CANZONE");
}%>
</a>

<a href="item_details?id=<%=order.getId()%>"> <% {
	out.print("\t Pagina che restituisce l'ARTISTA tramite la CANZONE");
}%>
</a>



</a>
</body>
</html>