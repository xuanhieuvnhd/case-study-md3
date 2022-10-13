<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>banner</title>
</head>
<body>
<section class="pt-5 pb-5 mt-0 align-items-center d-flex bg-dark"
         style="height:100vh; background-size: cover; background-image: url(https://img.upanh.tv/2022/10/12/banner.png);">
<%--   <div class="container-fluid">--%>
<%--        <div class="row  justify-content-center align-items-center d-flex text-center h-100">--%>
<%--            <div class="col-12 col-md-8  h-50 ">--%>
<%--                <h1 class="display-2  text-light mb-2 mt-5"><strong></strong></h1>--%>
<%--                <p class="lead  text-light mb-5"></p>--%>
<%--                <p><a class="btn bg-danger shadow-lg btn-round text-light btn-lg btn-rised"--%>
<%--                      href="${pageContext.request.contextPath}/products?action=display"></a></p>--%>

<%--                <div class="btn-container-wrapper p-relative d-block  zindex-1">--%>
<%--                    <a class="btn btn-link btn-lg   mt-md-3 mb-4 scroll align-self-center text-light"--%>
<%--                       href="http://google.com">--%>
<%--                        <i class="fa fa-angle-down fa-4x text-light"></i>--%>
<%--                    </a>--%>
<%--                </div>--%>
            </div>

        </div>
    </div>
</section>


<div class="container" style="padding-top: 20px">
    <div class="carousel slide border" data-ride="carousel" id="myCarousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
            <li data-slide-to="1" data-target="#myCarousel"></li>
            <li data-slide-to="2" data-target="#myCarousel"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img alt="Leopard" class="d-block w-100" src="view/img/background/banner1.png" width="100%">
                <div class="carousel-caption">
                    <a href="#">Learn more ></a>
                </div>
            </div>
            <div class="carousel-item">
                <img alt="Cat" class="d-block w-100" src="view/img/background/banner2.jpg" width="100%">
                <div class="carousel-caption">
                    <a href="#">Learn more ></a>
                </div>
            </div>

            <div class="carousel-item">
                <img alt="Lion" class="d-block w-100" src="view/img/background/banner3.jpg" width="100%">
                <div class="carousel-caption">
                    <a href="#">Learn more ></a>
                </div>
            </div>
        </div>
        <!-- Controls -->
        <a class="carousel-control-prev" data-slide="prev" href="#myCarousel" role="button">
            <span aria-hidden="true" class="carousel-control-prev-icon"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" data-slide="next" href="#myCarousel" role="button">
            <span aria-hidden="true" class="carousel-control-next-icon"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
</body>
</html>
