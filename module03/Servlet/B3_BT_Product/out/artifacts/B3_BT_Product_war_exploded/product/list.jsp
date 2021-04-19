<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 16-Apr-21
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Product</title>
</head>
<body>
<table>
    <h1>List All Product</h1>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td><a href="delete?id=${product.id}">Delete</a></td>
            <td><a href="update?id=${product.id}">Update</a></td>
            <td><a href="view?id=${product.id}">View Detail</a></td>
        </tr>
    </c:forEach>

    <tr><a href="create">Create new product</a></tr><br>

    <form action="search">
        <tr><input type="text" name="searchName" value="" placeholder="Search Product"></tr>
        <tr><button type="submit">Search</button></tr>
    </form>
</table>

</body>
</html>
