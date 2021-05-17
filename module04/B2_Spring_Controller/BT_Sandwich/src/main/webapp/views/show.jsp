<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 13-May-21
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show condiment</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<c:forEach var="c" items="${condiments}">
    <p>${c}</p>
</c:forEach>
</body>
</html>
