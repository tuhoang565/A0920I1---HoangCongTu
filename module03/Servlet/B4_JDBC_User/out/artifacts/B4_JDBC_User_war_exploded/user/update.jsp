<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 18-Apr-21
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
</head>
<body>
<h1>Update user</h1>
<form method="post" action="update">
    <div class="form-group col-4">
        <label for="id"></label>
        <input type="hidden" class="form-control" id="id" name="id" value="<c:out value='${user.id}'/>">
    </div>
    <div class="form-group col-4">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="<c:out value='${user.name}'/>">
    </div>
    <div class="form-group col-4">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" name="email" value="<c:out value='${user.email}'/>">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group col-4">
        <label for="exampleInputPassword1">Country</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="country" value="<c:out value='${user.country}'/>">
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
</body>
</html>
