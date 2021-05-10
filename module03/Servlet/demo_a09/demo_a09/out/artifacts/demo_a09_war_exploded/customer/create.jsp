<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 4/26/2021
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/customer?action=create" id="fomrAdd">
    <div class="form-group">
        <label for="exampleInputEmail1">Customer name</label>
        <input type="text" name="customerName" class="form-control" id="exampleInputEmail1"
               aria-describedby="emailHelp" value="<c:out value='${customer.nameCustomer}'/>"  >
        <p>
            <c:if test='${messageName!= null}'>
                <span style="color: red" class="message">${messageName}</span>
            </c:if>
        </p>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Birthday</label>
        <input type="text" name="birthday" value="<c:out value='${customer.birthday}'/>"
               class="form-control" id="exampleInputPassword1"  >
        <p>
            <c:if test='${messageBirthday != null}'>
                <span style="color: red" class="message">${messageBirthday}</span>
            </c:if>
        </p>
    </div>
    <div class="form-group">
        <label for="gender">Gender</label>
        <select name="gender" class="form-control" id="gender">
            <option value="true" ${customer.gender == 'true' ? 'selected':''}>Nam</option>
            <option value="false" ${customer.gender == 'false' ? 'selected':''}>Nữ</option>
        </select>
    </div>
    <div class="form-group">
        <label for="custype">Customer Type</label>
        <select name="cusType" class="form-control" id="custype">
            <c:forEach var="customerType" items="${customerTypeList}">
                <c:choose>
                    <c:when test="${customerType.idCustomerType.equals(customer.customerType.idCustomerType)}">
                        <option value="<c:out value='${customerType.idCustomerType}'/>" selected><c:out
                                value="${customerType.nameCustomerType}"></c:out></option>
                    </c:when>
                    <c:otherwise>
                        <option value="<c:out value='${customerType.idCustomerType}'/>"><c:out
                                value="${customerType.nameCustomerType}"></c:out></option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary" id="submit_id">ADD</button>
</form>
</body>
</html>
