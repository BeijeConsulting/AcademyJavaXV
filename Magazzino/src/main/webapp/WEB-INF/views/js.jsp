<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<button onclick="getAll()">getAll</button>
<button onclick="getById4()">getById4</button>
<script>

	function getAll(){
		fetch('prodotto/get')
			.then(response => response.json())
			.then(json => console.log(json))
	}
	
	function getById4(){
		fetch('prodotto/byid/4')
			.then(response => response.json())
			.then(json => console.log(json))
	}
	function post(){
		fetch('prodotto/insert', {
  		method: 'POST',
  		body: JSON.stringify({
    	descrizione: "Test",
    	nome: "Computerone",
    	quantita:"1000",
    	tipologia: "Svago"
  		}),
  		headers: {
   	 		'Content-type': 'application/json; charset=UTF-8',
  		},
		})
  		.then((response) => response.json())
  		.then((json) => console.log(json));
}
</script>
</body>
</html>