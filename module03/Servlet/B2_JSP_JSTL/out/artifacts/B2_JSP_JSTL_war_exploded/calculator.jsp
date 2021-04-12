<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 29-Mar-21
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post" action="/calculate">
<h1>Simple Calculator</h1>
<label>First number: </label>
<input type="number" name="first-number"><br>
<label>Operator: </label>
<select name="operator">
    <option>+</option>
    <option>-</option>
    <option>*</option>
    <option>/</option>
</select><br>
<label>Second number: </label>
<input type="number" name="second-number"><br>
<button type="submit">Calculate</button>
</form>
</body>
</html>
