<%-- 
    Document   : addProduct
    Created on : Mar 5, 2023, 10:13:09 PM
    Author     : toden
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Component/header.jsp" %>
    </head>
    <body>
        <%@include file="Component/navbar.jsp" %>
        <div class="container" style="padding: 50px;">
            <form action="AddCategory" method="post">
                <div class="mb-3">
                    <label for="" class="form-label">Category name</label>
                    <input name="name" class="form-control" id="" aria-describedby="" required>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
        <div class="container" style="padding: 50px;">
            <table border="1" class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${lc}">
                        <tr>
                            <td>${i.getCategory_id()}</td>
                            <td>${i.getName()}</td>
                            <td>
                                <a href="deleteCategory?id=${i.getCategory_id()}">
                                    <button type="button" class="btn btn-danger">Delete</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>
        <%@include file="Component/footer.jsp" %>
    </body>
</html>
