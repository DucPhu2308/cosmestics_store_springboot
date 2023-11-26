<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/15/2023
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<body>

<div class="form_login signin">
    <h4>Đăng nhập</h4>
    <form method="post" action="/login/checklogin">
        <div class="mb-3">
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Số điện thoại" name="phoneNumber">
        </div>
        <div class="mb-3">
            <div class="mb-3-password">
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Mật khẩu" name="password">
                <div class="login_input_show">
                    <i class='bx bx-show-alt'></i>
                </div>
                <div class="login_input_hidden">
                    <i class='bx bx-low-vision'></i>
                </div>
            </div>
        </div>


        <div class="form-login-btn">
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </div>
        <div class="form-login-forgot-password">
            <label> <input type="checkbox">Ghi nhớ đăng nhập</label>
            <a href="">Quên mật khẩu</a>
        </div>
        <div class="mb-3 form-check">
            <div class="tille-signin">
                <p>HOẶC</p>
            </div>
            <div class="signin_social">
                <a href="" class="btn btn-facebook"><i class="fa fa-facebook" aria-hidden="true"></i>
                    Facebook</a>
                <a href="" class="btn btn-google"><i class="fa fa-google" aria-hidden="true"></i> Google</a>
            </div>
            <div class="signin_not_have_account">
                <p>Bạn chưa có tài khoản. Hãy đăng ký
                    <a href="/register/">tại đây</a>
                </p>
            </div>

        </div>
    </form>
</div>
</body>
