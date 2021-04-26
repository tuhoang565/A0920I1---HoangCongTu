<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 17-Apr-21
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
</head>
<body>
<table class="table table-striped table-bordered">
    <h1>List All User</h1>
    <tr>
        <th scope="col" class="table-success">Id</th>
        <th scope="col" class="table-success">Name</th>
        <th scope="col" class="table-success">Email</th>
        <th scope="col" class="table-success">Country</th>
        <th scope="col" class="table-success">Function</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="update?id=${user.id}" class="btn btn-success">Update</a>
                <a href="delete?id=${user.id}" class="btn btn-success">Delete</a>
            </td>
        </tr>
    </c:forEach>

    <a class="btn btn-success" href="save" role="button">Create new user</a>

    <form class="form-inline my-2 my-lg-0" action="/search">
        <input class="form-control mr-sm-2 col-2" type="search" placeholder="Search" aria-label="Search" name="search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</table>
</body>
</html>
