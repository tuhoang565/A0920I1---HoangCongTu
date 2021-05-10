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
                    Contract
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/contracts?action=create">Insert</a>
                    <a class="dropdown-item" href="/contracts">List</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/customers?action=search">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchInput">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<form method="post">
    <div class="form-group col-4">
        <input type="hidden" class="form-control" id="customerId" name="customerId" value="<c:out value='${customer.customerId}'/>">
    </div>
    <div class="form-group col-4">
        <label for="customerType">Customer Type</label>
        <select class="form-control" id="customerType" name="customerType">
            <c:forEach items="${customerTypeList}" var="customerType">
                <c:choose>
                    <c:when test="${(customer.customerType.customerTypeId).equals(customerType.customerTypeId)}">
                        <option value="${customerType.customerTypeId}" selected>
                                ${customerType.customerTypeName}
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${customerType.customerTypeId}">
                                ${customerType.customerTypeName}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
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
        <label for="customerGender">Gender</label>
        <select class="form-control" id="customerGender" name="customerGender">
            <c:forEach items="${genderList}" var="customerGender">
                <c:choose>
                    <c:when test="${(customer.customerGender.genderId).equals(customerGender.genderId)}">
                        <option value="${customerGender.genderId}" selected>
                                ${customerGender.genderName}
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${customerGender.genderId}">
                                ${customerGender.genderName}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
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
<footer class="row"></footer>
</div>
</body>
</html>
