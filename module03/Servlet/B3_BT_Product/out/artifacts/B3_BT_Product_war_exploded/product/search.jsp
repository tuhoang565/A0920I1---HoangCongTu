<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 16-Apr-21
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Page</title>
</head>
<body>
<c:if test="${product != null}">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="<c:out value='${product.id}'/>"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<c:out value='${product.name}'/>"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" value="<c:out value='${product.description}'/>"></td>
        </tr>
        <tr>
            <td>Manufacturer</td>
            <td><input type="text" name="manufacturer" value="<c:out value='${product.manufacturer}'/>"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="<c:out value='${product.price}'/>"></td>
        </tr>
    </table>
</c:if>
<c:if test="${product == null}">
    <sout>No found product</sout>
</c:if>
</body>
</html>
