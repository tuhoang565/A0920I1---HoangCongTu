<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        Contract
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/contracts?action=create">Insert</a>
                        <a class="dropdown-item" href="/contracts">List</a>
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
    <form method="post">
        <%--    <div class="form-group col-4">--%>
        <%--        <label for="serviceId">Service Id</label>--%>
        <%--        <input type="hidden" class="form-control" id="serviceId" name="serviceId">--%>
        <%--    </div>--%>
        <div class="form-group col-4">
            <label for="serviceName">Service Name</label>
            <input type="text" class="form-control" id="serviceName" name="serviceName" value="${service.serviceName}">
            <p>
                <c:if test="${messageServiceName != null}">
                    <span style="color: red" class="message">${messageServiceName}</span>
                </c:if>
            </p>
        </div>
        <div class="form-group col-4">
            <label for="serviceArea">Service Area</label>
            <input type="text" class="form-control" id="serviceArea" name="serviceArea" value="${service.serviceArea}">
        </div>
        <div class="form-group col-4">
            <label for="serviceCost">Service Cost</label>
            <input type="text" class="form-control" id="serviceCost" name="serviceCost" value="${service.serviceCost}">
        </div>
        <div class="form-group col-4">
            <label for="serviceMaxPeople">Service Max People</label>
            <input type="text" class="form-control" id="serviceMaxPeople" name="serviceMaxPeople" value="${service.serviceMaxPeople}">
            <p>
                <c:if test="${messageServiceMaxPeople != null}">
                    <span style="color: red" class="message">${messageServiceMaxPeople}</span>
                </c:if>
            </p>
        </div>
        <div class="form-group col-4">
            <label for="rentType">Rent Type</label>
            <select class="form-control" id="rentType" name="rentType">
                <c:forEach items="${rentTypeList}" var="rentType">
                    <c:choose>
                        <c:when test="${(service.rentType.rentTypeId).equals(rentType.rentTypeId)}">
                            <option value="${rentType.rentTypeId}" selected>
                                ${rentType.rentTypeName}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${rentType.rentTypeId}">
                                    ${rentType.rentTypeName}
                            </option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-4">
            <label for="serviceType">Service Type</label>
            <select class="form-control" id="serviceType" name="serviceType">
                <c:forEach items="${serviceTypeList}" var="serviceType">
                    <c:choose>
                        <c:when test="${(service.serviceType.serviceTypeId).equals(serviceType.serviceTypeId)}">
                            <option value="${serviceType.serviceTypeId}" selected>
                                ${serviceType.serviceTypeName}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${serviceType.serviceTypeId}">
                                    ${serviceType.serviceTypeName}
                            </option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-4">
            <label for="standardRoom">Standard Room</label>
            <input type="text" class="form-control" id="standardRoom" name="standardRoom" value="${service.standardRoom}">
        </div>
        <div class="form-group col-4">
            <label for="descriptionOtherConvenience">Description Other Convenience</label>
            <input type="text" class="form-control" id="descriptionOtherConvenience" name="descriptionOtherConvenience" value="${service.descriptionOtherConvenience}">
        </div>
        <div class="form-group col-4">
            <label for="poolArea">Pool Area</label>
            <input type="text" class="form-control" id="poolArea" name="poolArea" value="${service.poolArea}">
        </div>
        <div class="form-group col-4">
            <label for="numberOfFloor">Number Of Floor</label>
            <input type="text" class="form-control" id="numberOfFloor" name="numberOfFloor" value="${service.numberOfFloor}">
            <p>
                <c:if test="${messageNumberOfFloor != null}">
                    <span style="color: red" class="message">${messageNumberOfFloor}</span>
                </c:if>
            </p>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>
</body>
</html>
