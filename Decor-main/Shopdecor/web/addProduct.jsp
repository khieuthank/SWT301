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
            <form action="AddProduct" method="post">
                <div class="mb-3">
                    <label for="" class="form-label">Product name</label>
                    <input name="Pname" class="form-control" id="" aria-describedby="" required>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Price</label>
                    <input type="number" min="0" class="form-control" name="Pprice" required>
                </div>
                <p>Category</p>
                <select name="Pca" class="form-select" aria-label="Default select example" onchange="handleCategoryChange(this)">
                    <c:forEach items="${cl}" var="cl">
                        <option value="${cl.getCategory_id()}">${cl.name}</option>
                    </c:forEach>
                    <option value="other">Other</option>
                </select>

                <script>
                    function handleCategoryChange(selectElement) {
                        var selectedValue = selectElement.value;
                        if (selectedValue === "other") {
                            window.location.href = "AddCategory"; 
                        }
                    }
                </script>

                <div class="mb-3">
                    <label for="" class="form-label">ImageLink</label>
                    <input name="Pimg" class="form-control" id="imgInput" required>
                    <img id="imgPreview" src="" alt="Ảnh" style="height: 50%; width: 50%;">

                    <script>
                        const imgInput = document.getElementById('imgInput');
                        const imgPreview = document.getElementById('imgPreview');

                        imgInput.addEventListener('input', function () {
                            const imgUrl = imgInput.value;
                            imgPreview.src = imgUrl;
                        });
                    </script>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Discription</label>
                    <input name="description" type="text" class="form-control" id="" required>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Quantity</label>
                    <input name="description" type="text" class="form-control" id="" required>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
        <%@include file="Component/footer.jsp" %>
    </body>
</html>
