<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 26-Mar-21
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<form method="post" action="/display-discount">
    <input type="text" name="describe" placeholder="Decribe product"/><br>
    <input type="number" name="list-price" placeholder="List Price"/><br>
    <input type="number" name="discount-percent" placeholder="Discount Percent"/><br>
    <button type="submit">Caculate</button>
</form>
</body>
</html>
