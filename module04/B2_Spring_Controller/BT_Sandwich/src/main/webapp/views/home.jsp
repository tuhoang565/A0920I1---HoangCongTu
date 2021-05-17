<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 13-May-21
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<div>
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        <input type="checkbox" name="condiment" value="Tomato">Tomato
        <input type="checkbox" name="condiment" value="Mustard">Mustard
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>
