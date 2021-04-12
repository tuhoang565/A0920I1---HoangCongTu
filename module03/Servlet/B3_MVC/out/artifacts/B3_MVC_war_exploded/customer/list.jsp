<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 02-Apr-21
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List All Customer</title>
</head>
<body>
<table>
    <a href="save">Create</a>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td><a href="delete?id=${customer.id}">Delete</a></td>
            <td><a href="update?id=${customer.id}">Update</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
