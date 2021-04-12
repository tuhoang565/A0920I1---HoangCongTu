<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 31-Mar-21
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Student</title>
</head>
<body>
    <table>
        <a href="save">Create new Student</a>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
        </tr>

        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.address}</td>
                <td><a href="delete?id=${student.id}">Delete</a></td>
                <td><a href="update?id=${student.id}">Update</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
