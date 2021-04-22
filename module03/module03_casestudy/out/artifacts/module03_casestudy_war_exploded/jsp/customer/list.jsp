<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 19-Apr-21
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/assert/bootstrap4/css/bootstrap-grid.css">
</head>
<body>
<div class="container-fluid">
    <header class="row">
        <img class="col-4" src="#"/>
        <div class="col-8">Hoang Cong Tu</div>
    </header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="row" style="height: 60%">
        <div class="col-2">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action">A simple default list group item</a>

                <a href="/customers?action=create" class="list-group-item list-group-item-action list-group-item-primary">Insert Customer</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">Item 2</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-success">Item 3</a>
            </div>
        </div>
        <div class="col-10" >
            <table class="table table-striped table-bordered">
                <h1>List All Customer</h1>
                <tr>
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
                        <td>${customer.customerType}</td>
                        <td>${customer.customerName}</td>
                        <td>${customer.customerBirthday}</td>
                        <td>${customer.customerGender}</td>
                        <td>${customer.customerIdCard}</td>
                        <td>${customer.customerPhone}</td>
                        <td>${customer.customerEmail}</td>
                        <td>${customer.customerAddress}</td>
                        <td><a href="#" class="btn btn-success">Update</a>
                            <a href="#" class="btn btn-success">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <footer class="row">footer</footer>
</div>
</body>
</html>
