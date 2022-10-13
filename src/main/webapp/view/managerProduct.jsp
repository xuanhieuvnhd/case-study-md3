<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Product Admin</title>
    <c:import url="head.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">


        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Danh Mục Sản Phẩm
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=displayShirt">Áo Nữ</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=displayDress">Váy Nữ</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=displayTrousers">Quần Nữ</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=display">Tất Cả Sản Phẩm</a>

                    </div>
                </li>
                <c:choose>
                    <c:when test="${user.userName == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/products?action=create">Thêm sản phẩm mới</a>
                        </li>
                    </c:when>
                </c:choose>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Sắp Xếp Sản Phẩm
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=displayPriceUp">Giá Tăng Dần</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=displayPriceDown">Giá Giảm Dần</a>

                    </div>
                </li>



            </ul>
            <form class="form-inline my-2 my-lg-0" method="post" action="products?action=search">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>

<div class="container">
    <div class="row">
        <c:forEach var="product" items="${listProduct}">
        <div class="col-lg-3 col-md-6 col-sm-12 hover13" style="padding-top: 20px">
            <div class="card" style="width: auto;">
                <img alt="Card image cap" class="card-img-top" src="${product.pathImage}">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">$${product.price}</p>
                    <c:choose>
                        <c:when test="${user.userName == 'admin'}">
                            <a class="btn btn-outline-danger btn-rounded waves-effect" href="${pageContext.request.contextPath}/products?action=edit&code=${product.code}" style="width: 90px">Edit</a>
                            <a class="btn btn-outline-danger btn-rounded waves-effect" href="${pageContext.request.contextPath}/products?action=delete&code=${product.code}" style="width: 90px">Delete</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/order?action=order&code=${product.code}" class="btn btn-primary">Add to cart</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
<c:import url="footer.jsp"/>

</body>
</html>
