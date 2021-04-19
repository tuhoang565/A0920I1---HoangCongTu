<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 01-Apr-21
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update student</title>
</head>
<body>
<h1>Update student</h1>

<form method="post" action="update">
    <table>
        <tr>
            <td>Id</td>
            <td><input name="id" type="text" value="<c:out value='${customer.id}'/>"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input name="name" type="text" value="<c:out value='${customer.name}'/>"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input name="email" type="text" value="<c:out value='${customer.email}'/>"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input name="address" type="text" value="<c:out value='${customer.address}'/>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form>
</body>
</html>
