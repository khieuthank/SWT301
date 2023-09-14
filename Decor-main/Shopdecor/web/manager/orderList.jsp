<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="helper" class="util.helper"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../Component/header.jsp" %>
    </head>
    <body>
        <%@include file="../Component/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <table class="table" style="margin-top: 100px" border="1">
                    <thead class="table">
                        <tr class="table">
                            <th scope="col">#</th>
                            <th scope="col">Customer Name</th>
                            <th scope="col">Date</th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>

                    <tbody >
                        <c:forEach var="i" items="${lo}">
                            <tr class="table-info">
                                <th scope="row">${loop.index+1}</th>
                                <th>${dao.findAccByID(i.getCustomerId()).getCustomer_name()}</th>
                                <th>${i.getOrderDate()}</th>
                                <th>${i.getTotal()}VNĐ</th>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>

            <%@include file="../Component/footer.jsp" %>
            <script>
                $('#btnSave').click(function () {
                    $('#btnBuyAll').prop('type', 'submit');
                    $('#btnBuyAll').click();
                })

            </script>
    </body>
</html>
