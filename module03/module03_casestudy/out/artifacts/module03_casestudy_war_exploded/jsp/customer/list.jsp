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
        <%--        <img class="col-4" src="/assert/images/t.jpg" height="100px" width="100px"/>--%>
        <%--        <div class="col-8">Hoang Cong Tu</div>--%>
    </header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
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
    </div>
    <footer class="row"></footer>
</div>
</body>
</html>
