<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 25-Apr-21
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-reboot.css">
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.js"></script>
    <script type="text/javascript" src="/assert/bootstrap4/js/bootstrap.bundle.js"></script>
</head>
<body>
<c:if test="${customer != null}">
<h1>Result</h1>
    <div class="col-10">
        <table class="table table-striped table-bordered">
            <h1>List All Customer</h1>
            <tr>
                <th scope="col" class="table-success">Customer Id</th>
                <th scope="col" class="table-success">Customer Type</th>
                <th scope="col" class="table-success">Name</th>
                <th scope="col" class="table-success">Birthday</th>
                <th scope="col" class="table-success">Gender</th>
                <th scope="col" class="table-success">Id card</th>
                <th scope="col" class="table-success">Phone Number</th>
                <th scope="col" class="table-success">Email</th>
                <th scope="col" class="table-success">Address</th>
                <th scope="col" class="table-success">Function</th>
            </tr>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.customerType}</td>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerBirthday}</td>
                    <td>${customer.customerGender}</td>
                    <td>${customer.customerIdCard}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerAddress}</td>
                    <td><a href="/customers?action=edit&customerId=${customer.customerId}" class="btn btn-success">Update</a>
                        <a href="/customers?action=delete&customerId=${customer.customerId}" class="btn btn-success">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<c:if test="${customer == null}">
    <sout>Not found customer</sout>
</c:if>
</body>
</html>
