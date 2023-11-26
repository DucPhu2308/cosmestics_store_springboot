<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="temp" value="0"/>
<body>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE CART</h1>
    </div>
</section>
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <a href="/cart/addCart">Thêm giỏ hàng</a>
                <table class="table table-striped">
                    <thead>
                    <tr>

                        <th scope="col">Tên giỏ hàng</th>
                        <th scope="col" class="text-center">Số lượng sản phẩm</th>
                        <th scope="col">Tổng giá</th>
                        <th scope="col" class="text-center">Chi tiết</th>

                        <th> </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i_cart" items="${listCartUser}">
                        <tr>
                            <td>${i_cart.name}</td>
                            <td class="text-center">${countProductByCartID.get(temp)} </td>

                            <td>${totalPriceByCartID.get(temp)} €</td>

                            <td class="text-center"><a href="/cart/${i_cart.id}">Xem chi tiết</a></td>
                            <td class="text-right">
                                <a href="#" class="btn btn-sm btn-primary">Sửa</a>
                                <a href="/cart/delete_cart/${i_cart.id}" class="btn btn-sm btn-danger">Xóa</a>


                                <button class="btn btn-sm btn-primary">Thanh toán</button>
                            </td>
                            <c:set var="temp" value="${temp+1}"/>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Sub-Total</td>
                        <td class="text-right">255,90 €</td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><strong>Total</strong></td>
                        <td class="text-right"><strong>346,90 €</strong></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-block btn-light">Continue Shopping</button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

