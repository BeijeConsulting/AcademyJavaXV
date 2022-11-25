<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>

fetch('./Magazzino/prodotti')
.then(response => response.json())
.then(json => console.log(json))

</script>

</body>
</html>