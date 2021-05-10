<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 26-Apr-21
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Service</title>
    <%--    jQuery and Popper--%>
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
<h1>Edit service</h1>
<br>
<form method="post">
    <div class="form-group col-4">
        <label for="serviceId">Service Id</label>
        <input type="text" class="form-control" id="serviceId" name="serviceId" value="<c:out value='${service.serviceId}'/>">
    </div>
    <div class="form-group col-4">
        <label for="serviceName">Service Name</label>
        <input type="text" class="form-control" id="serviceName" name="serviceName" value="<c:out value='${service.serviceName}'/>">
    </div>
    <div class="form-group col-4">
        <label for="serviceArea">Service Area</label>
        <input type="text" class="form-control" id="serviceArea" name="serviceArea" value="<c:out value='${service.serviceArea}'/>">
    </div>
    <div class="form-group col-4">
        <label for="serviceCost">Service Cost</label>
        <input type="text" class="form-control" id="serviceCost" name="serviceCost" value="<c:out value='${service.serviceCost}'/>">
    </div>
    <div class="form-group col-4">
        <label for="serviceMaxPeople">Service Max People</label>
        <input type="text" class="form-control" id="serviceMaxPeople" name="serviceMaxPeople" value="<c:out value='${service.serviceMaxPeople}'/>">
    </div>
    <div class="form-group col-4">
        <label for="rentTypeId">Rent Type Id</label>
        <input type="text" class="form-control" id="rentTypeId" name="rentTypeId" value="<c:out value='${service.rentTypeId}'/>">
    </div>
    <div class="form-group col-4">
        <label for="serviceTypeId">Service Type Id</label>
        <input type="text" class="form-control" id="serviceTypeId" name="serviceTypeId" value="<c:out value='${service.serviceTypeId}'/>">
    </div>
    <div class="form-group col-4">
        <label for="standardRoom">Standard Room</label>
        <input type="text" class="form-control" id="standardRoom" name="standardRoom" value="<c:out value='${service.standardRoom}'/>">
    </div>
    <div class="form-group col-4">
        <label for="descriptionOtherConvenience">Description Other Convenience</label>
        <input type="text" class="form-control" id="descriptionOtherConvenience" name="descriptionOtherConvenience" value="<c:out value='${service.descriptionOtherConvenience}'/>">
    </div>
    <div class="form-group col-4">
        <label for="poolArea">Pool Area</label>
        <input type="text" class="form-control" id="poolArea" name="poolArea" value="<c:out value='${service.poolArea}'/>">
    </div>
    <div class="form-group col-4">
        <label for="numberOfFloor">Number Of Floor</label>
        <input type="text" class="form-control" id="numberOfFloor" name="numberOfFloor" value="<c:out value='${service.numberOfFloor}'/>">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
