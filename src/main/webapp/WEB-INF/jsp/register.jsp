<%--
  Created by IntelliJ IDEA.
  User: Pedro
  Date: 11/11/2020
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registra't</title>
</head>
<body>

<h1>Formulari de Registre</h1>
<form action="/register" method="POST">
    Usuari
    <input type="text" name="username">
    Contrasenya
    <input type="password" name="password">
    Repeteix la contrasenya
    <input type="password" name="password1">
    <button type="submit">Registrar</button>


    <a href="/login">Haz login !</a>
</form>
</body>
</html>
