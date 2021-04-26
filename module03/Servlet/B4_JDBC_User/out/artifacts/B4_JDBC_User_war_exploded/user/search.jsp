<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 19-Apr-21
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
</head>
<body>
<c:if test="${user != null}">
    <table class="table table-striped table-bordered">
        <h1>Result</h1>
        <tr>
            <th scope="col" class="table-success">Id</th>
            <th scope="col" class="table-success">Name</th>
            <th scope="col" class="table-success">Email</th>
            <th scope="col" class="table-success">Country</th>
        </tr>

        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
        </tr>

    </table>
</c:if>
<c:if test="${user == null}">
    <sout>Not found user</sout>
</c:if>
</body>
</html>
