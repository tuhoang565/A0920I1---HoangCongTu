<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 08-May-21
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Currency</title>
</head>
<body>
<h1>Convert Currency</h1>
<form>
    <table>
        <tr>
            <select name="currency">
                <option value="USD">USD</option>
                <option value="VND">VND</option>
            </select>
        </tr>
        <tr>
            <lable>Enter value</lable>
            <input type="number" name="fromCurrency" value="${fromCurrency}">
        </tr>
        <tr>
            <label>Value</label>
            <input type="number" name="toCurrency" value="${toCurrency}">
        </tr>
        <button type="submit" value="Convert"></button>
    </table>
</form>
</body>
</html>
