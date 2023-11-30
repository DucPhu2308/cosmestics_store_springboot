
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE ORDER</h1>
    </div>
</section>

<div class="container mb-4">
    <form:form action="/order_cart/add_orderCart/${order.cart.id}" class="order_form" modelAttribute="order">
        <div class="mb-3">
            <label  class="form-label">Họ và tên</label>
            <input type="text" class="form-control" value="${order.cart.user.firstName} ${order.cart.user.lastName}" placeholder="Nhập họ và tên">
        </div>

        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <form:input path="address" type="text" class="form-control"  placeholder="Nhập địa chỉ"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" value="${order.cart.user.phone}" placeholder="Nhập số điện thoại">
        </div>

        <h3>Sản phẩm đã đặt</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"> </th>
                <th scope="col">Product</th>
                <th scope="col" class="text-center">Quantity</th>
                <th scope="col" class="text-right">Price</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="i_product" items="${order.cart.cart_products}">
            <tr>
                <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                <td>${i_product.product.name}</td>
                <td class="text-center">${i_product.quantity}</td>
                <td class="text-right">${i_product.totalPrice} €</td>
            </tr>
            </c:forEach>

            </tbody>
            <tr>
                <td></td>
                <td></td>
                <td>Sub-Total</td>
                <td class="text-right">255,90 €</td>
            </tr>

            <tr>
                <td></td>
                <td></td>
                <td><strong>Total</strong></td>
                <td class="text-right"><strong>346,90 €</strong></td>
            </tr>
        </table>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-block btn-light">Continue Shopping</button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase" type="submit">Xác nhận</button>
                </div>
            </div>
        </div>
    </form:form>

</div>

</body>
</html>
