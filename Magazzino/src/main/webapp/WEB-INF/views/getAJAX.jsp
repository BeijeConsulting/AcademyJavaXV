<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>AJAX</title>
</head>
<body>
<script>
  fetch('http://localhost:8080/Magazzino/rest/searchProduct/3')
          .then(response => response.json())
          .then(json => console.log(json))
</script>
</body>
</html>