<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 26-Apr-21
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List All Service</title>
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
<div class="container-fluid">
    <header class="row">
    </header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown1" type="button"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Employee
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Insert</a>
                        <a class="dropdown-item" href="#">List</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/services?action=create">Insert</a>
                        <a class="dropdown-item" href="/services">List</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Customer
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/customers?action=create">Insert</a>
                        <a class="dropdown-item" href="/customers">List</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Contact
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Insert</a>
                        <a class="dropdown-item" href="#">List</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/customers?action=search">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchInput">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="row" style="height: 80%">
        <%--        <div class="col-2">--%>
        <%--            <div class="list-group">--%>
        <%--                <a href="#" class="list-group-item list-group-item-action">A simple default list group item</a>--%>

        <%--                <a href="/customers?action=create" class="list-group-item list-group-item-action list-group-item-primary">Insert Customer</a>--%>
        <%--                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">Item 2</a>--%>
        <%--                <a href="#" class="list-group-item list-group-item-action list-group-item-success">Item 3</a>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="col-10">
            <table class="table table-striped table-bordered">
                <h1>List All Service</h1>
                <tr>
                    <th scope="col" class="table-success">Service Id</th>
                    <th scope="col" class="table-success">Service Name</th>
                    <th scope="col" class="table-success">Service Area</th>
                    <th scope="col" class="table-success">Service Cost</th>
                    <th scope="col" class="table-success">Service Max People</th>
                    <th scope="col" class="table-success">Rent Type</th>
                    <th scope="col" class="table-success">Service Type</th>
                </tr>
                <c:forEach items="${serviceList}" var="service">
                    <tr>
                        <td>${service.serviceId}</td>
                        <td>${service.serviceName}</td>
                        <td>${service.serviceArea}</td>
                        <td>${service.serviceCost}</td>
                        <td>${service.serviceMaxPeople}</td>
                        <td>${service.rentType.rentTypeName}</td>
                        <td>${service.serviceType.serviceTypeName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <footer class="row"></footer>
</div>
</body>
</html>
