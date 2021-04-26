<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 25-Apr-21
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-reboot.css">
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.js"></script>
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.bundle.js"></script>
</head>
<body>
<h1>Edit customer</h1>
<form method="post">
        <div class="form-group col-4">
            <label for="customerId">Customer Id</label>
            <input type="text" class="form-control" id="customerId" name="customerId" value="<c:out value='${customer.customerId}'/>">
        </div>
    <div class="form-group col-4">
        <label for="customerType">Customer Type</label>
        <input type="text" class="form-control" id="customerType" name="customerType" value="<c:out value='${customer.customerType}'/>">
    </div>
    <div class="form-group col-4">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="customerName" value="<c:out value='${customer.customerName}'/>">
    </div>
    <div class="form-group col-4">
        <label for="birthday">Birthday</label>
        <input type="date" class="form-control" id="birthday" name="customerBirthday" value="<c:out value='${customer.customerBirthday}'/>">
    </div>
    <div class="form-group col-4">
        <label for="gender">Gender</label>
        <input type="text" class="form-control" id="gender" name="customerGender" value="<c:out value='${customer.customerGender}'/>">
    </div>
    <div class="form-group col-4">
        <label for="idCard">Id Card</label>
        <input type="text" class="form-control" id="idCard" name="customerIdCard" value="<c:out value='${customer.customerIdCard}'/>">
    </div>
    <div class="form-group col-4">
        <label for="phone">Phone Number</label>
        <input type="text" class="form-control" id="phone" name="customerPhone" value="<c:out value='${customer.customerPhone}'/>">
    </div>
    <div class="form-group col-4">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" name="customerEmail" value="<c:out value='${customer.customerEmail}'/>">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group col-4">
        <label for="address">Address</label>
        <input type="text" class="form-control" id="address" name="customerAddress" value="<c:out value='${customer.customerAddress}'/>">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
