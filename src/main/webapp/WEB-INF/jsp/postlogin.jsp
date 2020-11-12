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
    <title>Title</title>
</head>
<body>
<h2>Post login! !</h2>

<c:if test="${not empty username}">
    Login correcto !!!!
</c:if>

</body>
</html>
