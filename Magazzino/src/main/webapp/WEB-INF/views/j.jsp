<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>

	console.log("test");

	fetch('api/product')
		.then(response => response.json())
		.then(json => console.log(json))

	
	fetch('api/addProd',{
		method: 'POST',
		body: JSON.stringify({
			desc: "a bi bo",
			tipo: "scimmia",
			name: "pantaloni",
			quantity:"200"			
		}),
		headers: {
			"Content-type": "application/json; charset=UTF-8",
		},
	})
	.then((response) => response.json())
	.then((json) => console.log(json));
</script>


  

</body>
</html>