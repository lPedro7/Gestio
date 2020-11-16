<%--
  Created by IntelliJ IDEA.
  User: Pedro
  Date: 16/11/2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nueva Nota</title>
</head>
<body>
<form action="/newNote" method="POST">
    Titulo
    <input type="text" name="titulo">
    Texto
    <input type="textarea" name="text">
    <button type="submit">Crear Nota</button>
</form>
</body>
</html>
