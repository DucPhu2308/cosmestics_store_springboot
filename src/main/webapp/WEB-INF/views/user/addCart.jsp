<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<body>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE CART</h1>
    </div>
</section>
<div class="container">
    <div class="form_login signin">
        <h4>Thêm giỏ hàng</h4>
        <form:form action="/cart/add" modelAttribute="addCart">
            <div class="mb-3">
                <label>Tên giỏ hàng</label>
                <form:input type="text" class="form-control" path="name"
                       placeholder="Tên giỏ hàng"/>
            </div>
            <div class="mb-3">
                <label>Khách hàng</label>
                <input type="text" class="form-control" value="${firstName} ${lastName}" disabled>
            </div>


            <div class="form-login-btn">
                <button type="submit" class="btn btn-primary">Thêm giỏ hàng</button>
            </div>
            <div class="form-login-btn">
                <a href="/" class="btn btn-danger">Hủy</a>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>