<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 05-Apr-21
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer Information</title>
</head>
<body>
<form method="post" action="/update">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
        </tr>
        </tr>
    </table>
</form>
</body>
</html>
