<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <c:import url="head.jsp"/>
    <style>
        .message{
            color: #e80368;
        }
    </style>
</head>
<body>
<c:import url="header.jsp"/>
<form class="form-horizontal" method="post" action="products?action=create" accept-charset="UTF-8">
    <fieldset>

        <!-- Form Name -->
        <legend>PRODUCTS</legend>
        <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>

        <!-- Text input-->
        <div class="form-group ">
            <label class="col-md-4 control-label" for="product_code">Product Code</label>
            <div class="col-md-4">
                <input id="product_code" name="product_code" placeholder="Product Code" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_name">Product Name</label>
            <div class="col-md-4">
                <input id="product_name" name="product_name" placeholder="Product Name" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_categorie">Product Category</label>
            <div class="col-md-4">
                <select id="product_categorie" name="product_categorie" class="form-control">
                    <option value="dress">dress</option>
                    <option value="shirt">shirt</option>
                    <option value="trousers">trousers</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="product_quantity"> Quantity</label>
            <div class="col-md-4">
                <input id="product_quantity" name="product_quantity" placeholder="Quantity" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="product_price"> Price</label>
            <div class="col-md-4">
                <input id="product_price" name="product_price" placeholder="Price" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="product_img">PathImage</label>
            <div class="col-md-4">
                <input id="product_img" name="product_img" placeholder="PathImage" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="accept"></label>
            <div class="col-md-4">
                <button id="accept" name="accept" class="btn btn-primary">Accept</button>
            </div>
        </div>
        </div>
        </div>
    </fieldset>

</form>
<c:import url="footer.jsp"/>
</body>
</html>
