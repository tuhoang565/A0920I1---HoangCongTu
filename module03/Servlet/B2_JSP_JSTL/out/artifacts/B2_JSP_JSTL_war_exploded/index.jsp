<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 26-Mar-21
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Danh sach khach hang</h1>
  <table border="blue 1px">
    <c:forTokens items="Tom,Jerry,Donald" delims="," var="name">
    <tr>
    <c:out value="${name}"/>
    </tr>
    </c:forTokens>
  </table>
  </body>
</html>
