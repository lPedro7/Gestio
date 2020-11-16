<%--
  Created by IntelliJ IDEA.
  User: Pedro
  Date: 11/11/2020
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<h2>Post login! !</h2>

<% String username = request.getParameter("username"); %>
Bienvenido  <%= username %> !

<p>Tus notas </p>
<a href="/newNote">Nueva Nota +</a>

</body>
</html>
