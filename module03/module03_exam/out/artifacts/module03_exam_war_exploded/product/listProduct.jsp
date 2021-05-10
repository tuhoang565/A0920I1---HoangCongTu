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
    <title>List All Product</title>
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

    </header>

    <a class="nav-link" href="/products?action=create">Insert Product</a>
    <div class="row" style="height: 80%">
        <div class="col-10">
            <table class="table table-striped table-bordered" id="customer">
                <h1>List All Product</h1>
                <tr>
                    <th scope="col" class="table-success">Id</th>
                    <th scope="col" class="table-success">Name</th>
                    <th scope="col" class="table-success">Price</th>
                    <th scope="col" class="table-success">Discount</th>
                    <th scope="col" class="table-success">Stock</th>
                </tr>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productPrice}</td>
                        <td>${product.productDiscount}</td>
                        <td>${product.productExist}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>
