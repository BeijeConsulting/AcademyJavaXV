<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
   <head>
      <title>E-Commerce</title>
   </head>
   <body>
      <h1>Benvenuto su HopperShop!!</h1>
      <h3>Effettua l'accesso oppure registrati</h3>
   <form>
      <input type="button" value="Accedi" onclick="document.getElementById('accessDiv').removeAttribute('hidden');document.getElementById('registerDiv').setAttribute('hidden','hidden')">
      <input type="button" value="Registrati" onclick="document.getElementById('registerDiv').removeAttribute('hidden');document.getElementById('accessDiv').setAttribute('hidden','hidden')">
   </form>

      <div id="accessDiv" hidden="hidden">
         <form action="./login" method="post">
            <label for="username">Username:</label><br>
            <input type="text" name="username" value=""><br>
            <label for="password">Password:</label><br>
            <input type="password" name="password" value=""><br><br>
            <input type="submit" value="Submit">
         </form>
      </div>
      <div id="registerDiv" hidden="hidden">
         <form action="./register" method="post">
            <label for="email">Email:</label><br>
            <input type="text" name="email" value=""><br>
            <label for="nome">Nome:</label><br>
            <input type="text" name="nome" value=""><br>
            <label for="cognome">Cognome:</label><br>
            <input type="text" name="cognome" value=""><br>
            <label for="password">Password:</label><br>
            <input type="password" name="password" value=""><br><br>
            <input type="submit" value="Submit">
         </form>
      </div>

   </body>
</html>