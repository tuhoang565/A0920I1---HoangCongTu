<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 27-Apr-21
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Employee</title>
    <%--    jQuery and Popper--%>
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
<div class="container-fluid">
    <header class="row">
        <%--        <img class="col-4" src="/assert/images/t.jpg" height="100px" width="100px"/>--%>
        <%--        <div class="col-8">Hoang Cong Tu</div>--%>
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
                        <a class="dropdown-item" href="/employees?action=create">Insert</a>
                        <a class="dropdown-item" href="/employees">List</a>
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
            <form class="form-inline my-2 my-lg-0" action="/customers">
                <input type="hidden" name="action" value="search">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                       name="searchInput">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
<%--    <div class="row" style="height: 80%">--%>
        <form method="post">
            <div class="form-group col-4">
                <label for="employeeId">Employee Id</label>
                <input type="text" class="form-control" id="employeeId" name="employeeId">
            </div>
            <div class="form-group col-4">
                <label for="employeeName">Employee Name</label>
                <input type="text" class="form-control" id="employeeName" name="employeeName">
            </div>
            <div class="form-group col-4">
                <label for="employeeBirthday">Employee Birthday</label>
                <input type="date" class="form-control" id="employeeBirthday" name="employeeBirthday">
            </div>
            <div class="form-group col-4">
                <label for="employeeIdCard">Employee Id Card</label>
                <input type="text" class="form-control" id="employeeIdCard" name="employeeIdCard">
            </div>
            <div class="form-group col-4">
                <label for="employeeSalary">Employee Salary</label>
                <input type="text" class="form-control" id="employeeSalary" name="employeeSalary">
            </div>
            <div class="form-group col-4">
                <label for="employeePhone">Employee Phone</label>
                <input type="text" class="form-control" id="employeePhone" name="employeePhone">
            </div>
            <div class="form-group col-4">
                <label for="employeeEmail">Employee Email</label>
                <input type="text" class="form-control" id="employeeEmail" name="employeeEmail">
            </div>
            <div class="form-group col-4">
                <label for="employeeAddress">Employee Address</label>
                <input type="text" class="form-control" id="employeeAddress" name="employeeAddress">
            </div>
            <div class="form-group col-4">
                <label for="position">Position</label>
                <select class="form-control" id="position" name="position">
                    <option value="1">Recetionist</option>
                    <option value="2">Waiter</option>
                    <option value="3">Expert</option>
                    <option value="4">Supervisor</option>
                    <option value="5">Manager</option>
                    <option value="6">Director</option>
                </select>
            </div>
            <div class="form-group col-4">
                <label for="educationDegree">Education Degree</label>
                <select class="form-control" id="educationDegree" name="educationDegree">
                    <option value="1">Master</option>
                    <option value="2">Bacherlor </option>
                    <option value="3">The Degree Of Associate</option>
                    <option value="4">Intermediate Degree</option>
                </select>
            </div>
            <div class="form-group col-4">
                <label for="division">Division</label>
                <select class="form-control" id="division" name="division">
                    <option value="1">Sales Dept</option>
                    <option value="2">Administration Dept</option>
                    <option value="3">Customer Dept</option>
                    <option value="4">Manage Dept</option>
                </select>
            </div>
            <div class="form-group col-4">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <button type="submit" class="btn btn-success">Create</button>
        </form>
<%--    </div>--%>
    <footer class="row"></footer>
</div>
</body>
</html>
