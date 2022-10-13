<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>header</title>

</head>
<body>
<header class="container">
    <nav class="navbar navbar-expand-md bg-white navbar-white fixed-top">
        <a class="nav-link navbar-brand" href="/products"><img height="50" src="view/img/background/logo1.png"
                                                               width="145"/></a>
        <button class="navbar-toggler" data-target="#collapsibleNavbar" data-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/products"><span class="text-dark">Trang chủ</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardropComputer">
                        <span class="text-dark">Giới Thiệu</span>
                    </a>

                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Tổng quan về Shop</a>
                        <a class="dropdown-item" href="#">Lịch sử hình thành</a>
                        <a class="dropdown-item" href="#">Tầm nhìn sứ mệnh</a>
                        <a class="dropdown-item" href="#">Câu chuyện thương hiệu</a>

                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardropAccessories">
                        <span class="text-dark">Sản Phẩm</span>
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Áo Nữ</a>
                        <a class="dropdown-item" href="#">Váy Nữ</a>
                        <a class="dropdown-item" href="#">Quần Nữ</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=display">Tất
                            Cả Sản Phẩm</a>

                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="text-dark">Hệ Thống Cửa Hàng</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardropShop">
                        <span class="text-dark">Liên Hệ</span>
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Cá Nhân</a>
                        <a class="dropdown-item" href="#">Doanh Nghiệp</a>

                    </div>
                </li>

            </ul>
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${user ==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/users?action=login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/users?action=create">Signup</a>
                        </li>
                    </c:when>
                    <c:when test="${user.userName == 'admin'}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardropShop">
                                <span class="text-dark"><c:out value="${user.userName}"/></span>
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=display">Product</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/users?action=display">
                                    User</a>
                                <a class="dropdown-item" href="logout">Logout</a>

                            </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardropShop">
                                <span class="text-dark"><c:out value="${user.userName}"/></span>
                            </a>

                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/order?action=cart">
                                    Cart</a>
                                <a class="dropdown-item" href="logout">Logout</a>

                            </div>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>

</header>
</body>
</html>
