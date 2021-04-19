<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 15-Apr-21
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Customer</title>
</head>
<body>

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
</table>

</body>
</html>
