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
            <td>ID:</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</form>
</body>
</html>
