<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 03-May-21
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
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
<form method="post">
    <div class="form-group col-4">
        <label for="productName">Name</label>
        <input type="text" class="form-control" id="productName" name="productName"
               value="<c:out value='${product.productName}'/>">
    </div>
    <div class="form-group col-4">
        <label for="productPrice">Price</label>
        <input type="text" class="form-control" id="productPrice" name="productPrice"
               value="<c:out value='${product.productPrice}'/>">
    </div>
    <div class="form-group col-4">
        <label for="productDiscount">Discount</label>
        <select class="form-control" id="productDiscount" name="productDiscount">
            <option value="5">5%</option>
            <option value="10">10%</option>
            <option value="15">15%</option>
            <option value="20">20%</option>
        </select>
    </div>
    <div class="form-group col-4">
        <label for="productExist">Stock</label>
        <input type="text" class="form-control" id="productExist" name="productExist"
               value="<c:out value='${product.productExist}'/>">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
