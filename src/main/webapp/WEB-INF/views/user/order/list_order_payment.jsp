<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

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
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Tên giỏ hàng</th>
                        <th scope="col">Trạng thái thanh toán</th>
                        <th scope="col">Chi tiết</th>
                    </tr>
                    </thead>
                    <tbody class="row_cart">
                    <c:forEach items="${carts}" var="cart">
                        <tr>
                            <td>${cart.name}</td>
                            <td>${cart.status}</td>
                            <td><a href="#">Xem chi tiết</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>

    </div>
</div>
</body>
</html>
