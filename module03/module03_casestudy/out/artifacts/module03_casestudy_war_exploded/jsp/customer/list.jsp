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
    <%--    dataTables--%>
    <%--    <script type="text/javascript" src="/assert/bootstrap4/dataTable/jquery.dataTables.js"></script>--%>
    <%--    <script type="text/javascript" src="/assert/bootstrap4/dataTable/dataTables.bootstrap4.min.js"></script>--%>
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
       <%
        String username = (String)session.getAttribute("username");
        if(session != null){
            out.print("Hello, " + username);
        }else {
            out.print("Hello friend" );
        }
       %>
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
            <li class="nav-item">
                <a class="nav-link" href="/logout">Log out</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Log in</a>
            </li>
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
            <table class="table table-striped table-bordered" id="customer">
                <h1>List All Customer</h1>
                <tr>
                    <th scope="col" class="table-success">Customer Id</th>
                    <th scope="col" class="table-success">Customer Type</th>
                    <th scope="col" class="table-success">Name</th>
                    <th scope="col" class="table-success">Birthday</th>
                    <th scope="col" class="table-success">Gender</th>
                    <th scope="col" class="table-success">Function</th>
                </tr>
                <c:forEach items="${customerList}" var="customer">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.customerType.customerTypeName}</td>
                        <td>${customer.customerName}</td>
                        <td>${customer.customerBirthday}</td>
                        <td>${customer.customerGender.genderName}</td>
                        <td><a href="/customers?action=edit&customerId=${customer.customerId}" class="btn btn-success">Update</a>
                            <a class="btn btn-success" href="#"
                               onclick="customerSetId('${customer.customerId}','${customer.customerName}')"
                               data-toggle="modal" data-target="#deleteModal">Delete</a>
                            <a href="/customers?action=view&customerId=${customer.customerId}" class="btn btn-success">Detail</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <footer class="row"></footer>
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>
                </div>
            </div>
        </div>
    </div>

    <form action="/customers" method="get" id="deleteCustomer">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="customerId" id="customerId">
    </form>

    <script>
        function customerSetId(customerId, customerName) {
            document.getElementById("customerId").value = customerId;
            document.getElementById("modelId").value = "Do you want delete customer name: " + customerName;
        }

        function submitDelete() {
            <!-- để submit form delete  -->
            document.getElementById("deleteCustomer").submit();
        }
    </script>

    <%--        DataTable--%>
    <%--    <script>--%>
    <%--        $(document).ready(function () {--%>
    <%--            $('#customer').dataTable({--%>
    <%--                "dom": 'lrtip',--%>
    <%--                "lengthChange": false,--%>
    <%--                "pageLength": 5--%>
    <%--            })--%>
    <%--        })--%>
    <%--    </script>--%>
</div>
</body>
</html>
