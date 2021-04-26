<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 26-Apr-21
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Service</title>
<%--    jQuery va popper--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="/assert/bootstrap4/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.bundle.js"></script>
<%--CSS--%>
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-reboot.css">
<%--JavaScript--%>
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.js"></script>
</head>
<body>
<h1>Create new service</h1>
<br>
<form method="post">
        <div class="form-group col-4">
            <label for="serviceId">Service Id</label>
            <input type="text" class="form-control" id="serviceId" name="serviceId">
        </div>
    <div class="form-group col-4">
        <label for="serviceName">Service Name</label>
        <input type="text" class="form-control" id="serviceName" name="serviceName">
    </div>
    <div class="form-group col-4">
        <label for="serviceArea">Service Area</label>
        <input type="text" class="form-control" id="serviceArea" name="serviceArea">
    </div>
    <div class="form-group col-4">
        <label for="serviceCost">Service Cost</label>
        <input type="date" class="form-control" id="serviceCost" name="serviceCost">
    </div>
    <div class="form-group col-4">
        <label for="serviceMaxPeople">Service Max People</label>
        <input type="text" class="form-control" id="serviceMaxPeople" name="serviceMaxPeople">
    </div>
    <div class="form-group col-4">
        <label for="rentTypeId">Rent Type Id</label>
        <input type="text" class="form-control" id="rentTypeId" name="rentTypeId">
    </div>
    <div class="form-group col-4">
        <label for="serviceTypeId">Service Type Id</label>
        <input type="text" class="form-control" id="serviceTypeId" name="serviceTypeId">
    </div>
    <div class="form-group col-4">
        <label for="standardRoom">Standard Room</label>
        <input type="email" class="form-control" id="standardRoom" name="standardRoom">
    </div>
    <div class="form-group col-4">
        <label for="descriptionOtherConvenience">Description Other Convenience</label>
        <input type="text" class="form-control" id="descriptionOtherConvenience" name="descriptionOtherConvenience">
    </div>
    <div class="form-group col-4">
        <label for="poolArea">Pool Area</label>
        <input type="text" class="form-control" id="poolArea" name="poolArea">
    </div>
    <div class="form-group col-4">
        <label for="numberOfFloor">Number Of Floor</label>
        <input type="text" class="form-control" id="numberOfFloor" name="numberOfFloor">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</body>
</html>
