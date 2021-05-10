<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 4/26/2021
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>

<a class="btn btn-success" href="/customer?action=create"> Create</a>
<table id="customer" class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Customer id</th>
        <th scope="col">Customer name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Gender</th>
        <th scope="col">Customer type</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cus" items="${listCus}">
        <tr>
            <td><c:out value="${cus.idCustomer}"/></td>
            <td><c:out value="${cus.nameCustomer}"/></td>
            <td><c:out value="${cus.birthday}"/></td>
            <td><c:out value="${cus.gender ? 'Nam':'Nữ'}"/></td>
            <td><c:out value="${cus.customerType.nameCustomerType}"/></td>
            <td><a class="btn btn-danger" href="#" onclick="customerSetId('${cus.idCustomer}','${cus.nameCustomer}')"
                   data-toggle="modal" data-target="#deleteModal">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



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

<form action="/customer" method="post" id="deleteCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="idCustomer" id="idCustomer">
</form>

<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap413/js/popper.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../../bootstrap413/js/bootstrap.min.js"></script>
<script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
<script>

    function customerSetId(id, name) {
        document.getElementById("idCustomer").value = id;
        document.getElementById("modelId").value = "Do you want delete customer name: " + name;
    }

    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteCustomer").submit();
    }

</script>

<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>


</body>
</html>
