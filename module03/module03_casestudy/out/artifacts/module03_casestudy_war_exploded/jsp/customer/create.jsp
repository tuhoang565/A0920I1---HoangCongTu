<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 18-Apr-21
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
</head>
<body>
<h1>Create new customer</h1>
<br>
<form method="post">
    <div class="form-group col-4">
        <label for="customerType">Customer Type</label>
        <input type="text" class="form-control" id="customerType" name="customerType">
    </div>
    <div class="form-group col-4">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="customerName">
    </div>
    <div class="form-group col-4">
        <label for="birthday">Birthday</label>
        <input type="date" class="form-control" id="birthday" name="customerBirthday">
    </div>
    <div class="form-group col-4">
        <label for="gender">Gender</label>
        <input type="text" class="form-control" id="gender" name="customerGender">
    </div>
    <div class="form-group col-4">
        <label for="idCard">Id Card</label>
        <input type="text" class="form-control" id="idCard" name="customerIdCard">
    </div>
    <div class="form-group col-4">
        <label for="phone">Phone</label>
        <input type="text" class="form-control" id="phone" name="customerPhone">
    </div>
    <div class="form-group col-4">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" name="customerEmail">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group col-4">
        <label for="address">Address</label>
        <input type="text" class="form-control" id="address" name="customerAddress">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
