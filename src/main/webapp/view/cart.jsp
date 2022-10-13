<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <c:import url="head.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<section>

    <!--Grid row-->
    <div class="row">

        <!--Grid column-->
        <div class="col-lg-8">

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4 wish-list">

                    <h5 class="mb-4">Cart (<span>${size}</span> items)</h5>

                <c:forEach var="product" items="${listCart}">
                    <div class="row mb-4">
                        <div class="col-md-5 col-lg-3 col-xl-3">
                            <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                <img class="img-fluid w-100"
                                     src="${product.pathImage}"
                                     alt="Sample">
                            </div>
                        </div>
                        <div class="col-md-7 col-lg-9 col-xl-9">
                            <div>
                                <div class="d-flex justify-content-between">
                                    <div>
                                        <h5>${product.name}</h5>
                                    </div>
                                    <div>
                                        <div class="def-number-input number-input safari_only mb-0 w-100">
                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                    class="minus decrease"></button>
                                            <input class="quantity" min="0" name="quantity" value="1" type="number">
                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                    class="plus increase"></button>
                                        </div>
                                        <small id="passwordHelpBlock" class="form-text text-muted text-center">
                                            (Note, 1 piece)
                                        </small>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <a href="/order?action=remove&code=${product.code}" type="button"
                                           class="card-link-secondary small text-uppercase mr-3"><i
                                                class="fas fa-trash-alt mr-1"></i> Remove item </a>
                                        <a href="#!" type="button" class="card-link-secondary small text-uppercase"><i
                                                class="fas fa-heart mr-1"></i> Move to wish list </a>
                                    </div>
                                    <p class="mb-0"><span><strong id="summary">Price: $${product.price}</strong></span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr class="mb-4">
                </c:forEach>



                </div>
            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4">

                    <h5 class="mb-4">Expected shipping delivery</h5>

                    <p class="mb-0"> Thu., 12.03. - Mon., 16.03.</p>
                </div>
            </div>
            <!-- Card -->

            <!-- Card -->

            <!-- Card -->

        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-lg-4">

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4">

                    <h5 class="mb-3">The total amount of</h5>

                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                            Temporary amount
                            <span>$${totalMount}</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                            Shipping
                            <span>Free</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                            <div>
                                <strong>The total amount of</strong>
                                <strong>
                                    <p class="mb-0">(including VAT)</p>
                                </strong>
                            </div>
                            <span><strong>$${totalMount}</strong></span>
                        </li>
                    </ul>

                    <button type="button" class="btn btn-primary btn-block">Go to checkout</button>

                </div>
            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4">

                    <a class="dark-grey-text d-flex justify-content-between" data-toggle="collapse"
                       href="#collapseExample"
                       aria-expanded="false" aria-controls="collapseExample">
                        Add a discount code (optional)
                        <span><i class="fas fa-chevron-down pt-1"></i></span>
                    </a>
                    <h5 class="mb-4">We accept</h5>

                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
                         alt="Visa">
                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
                         alt="American Express">
                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
                         alt="Mastercard">
                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
                         alt="PayPal acceptance mark">

                    <div class="collapse" id="collapseExample">
                        <div class="mt-3">
                            <div class="md-form md-outline mb-0">
                                <input type="text" id="discount-code" class="form-control font-weight-light"
                                       placeholder="Enter discount code">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Card -->

        </div>
        <!--Grid column-->

    </div>
    <!-- Grid row -->

</section>
<!--Section: Block Content-->
<c:import url="footer.jsp"/>
</body>
</html>
