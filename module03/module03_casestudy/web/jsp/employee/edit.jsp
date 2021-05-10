<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 27-Apr-21
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
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
            <form class="form-inline my-2 my-lg-0" action="/customers?action=search">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                       name="searchInput">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <%--    <div class="row" style="height: 80%">--%>
    <h1>Edit Employee</h1>
    <form method="post">
        <div class="form-group col-4">
            <label for="employeeId">Employee Id</label>
            <input type="text" class="form-control" id="employeeId" name="employeeId"
                   value="<c:out value='${employee.employeeId}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeeName">Employee Name</label>
            <input type="text" class="form-control" id="employeeName" name="employeeName"
                   value="<c:out value='${employee.employeeName}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeeBirthday">Employee Birthday</label>
            <input type="date" class="form-control" id="employeeBirthday" name="employeeBirthday"
                   value="<c:out value='${employee.employeeBirthday}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeeIdCard">Employee Id Card</label>
            <input type="text" class="form-control" id="employeeIdCard" name="employeeIdCard"
                   value="<c:out value='${employee.employeeIdCard}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeeSalary">Employee Salary</label>
            <input type="text" class="form-control" id="employeeSalary" name="employeeSalary"
                   value="<c:out value='${employee.employeeSalary}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeePhone">Employee Phone</label>
            <input type="text" class="form-control" id="employeePhone" name="employeePhone"
                   value="<c:out value='${employee.employeePhone}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeeEmail">Employee Email</label>
            <input type="text" class="form-control" id="employeeEmail" name="employeeEmail"
                   value="<c:out value='${employee.employeeEmail}'/>">
        </div>
        <div class="form-group col-4">
            <label for="employeeAddress">Employee Address</label>
            <input type="text" class="form-control" id="employeeAddress" name="employeeAddress"
                   value="<c:out value='${employee.employeeAddress}'/>">
        </div>
        <div class="form-group col-4">
            <label for="positionId">Position Id</label>
            <input type="text" class="form-control" id="positionId" name="positionId"
                   value="<c:out value='${employee.positionId}'/>">
        </div>
        <div class="form-group col-4">
            <label for="educationDegreeId">Education Degree Id</label>
            <input type="text" class="form-control" id="educationDegreeId" name="educationDegreeId"
                   value="<c:out value='${employee.educationDegreeId}'/>">
        </div>
        <div class="form-group col-4">
            <label for="divisionId">Division Id</label>
            <input type="text" class="form-control" id="divisionId" name="divisionId"
                   value="<c:out value='${employee.divisionId}'/>">
        </div>
        <div class="form-group col-4">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username"
                   value="<c:out value='${employee.username}'/>">
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>

    <%--    </div>--%>
    <footer class="row"></footer>
</body>
</html>
