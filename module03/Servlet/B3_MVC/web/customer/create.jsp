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
    <title>Create student</title>
</head>
<body>
<h1>Create new student</h1>
<form action="save" method="post">
    <table>
        <tr>
            <td>Id</td>
            <input name="id" type="text">
        </tr><br/>
        <tr>
            <td>Name</td>
            <input name="name" type="text">
        </tr><br/>
        <tr>
            <td>Email</td>
            <input name="email" type="text">
        </tr><br/>
        <tr>
            <td>Address</td>
            <input name="address" type="text">
        </tr><br/>
        <tr><input type="submit" value="Create"></tr>
    </table>
</form>
</body>
</html>
