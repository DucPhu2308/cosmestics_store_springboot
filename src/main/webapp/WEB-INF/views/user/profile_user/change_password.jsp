
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form_login fill_new_password">
    <form class="form_fill_new_password_content" action="#" method="post">
        <div class="form_fill_new_password_content_title">
            <h4>Thay đổi mật khẩu</h4>
            <p>Nhập mật khẩu mới cho tài khoản</p>
        </div>
        <div class="form_fill_new_password_content_input">
            <input type="password" placeholder="Nhập mật khẩu cũ" name="old_password">
            <div class="login_input_show">
                <i class='bx bx-show-alt'></i>
            </div>
            <div class="login_input_hidden">
                <i class='bx bx-low-vision'></i>
            </div>
        </div>
        <div class="form_fill_new_password_content_input newPassword">
            <input type="password" placeholder="Nhập mật khẩu mới" name="new_password">
            <div class="login_input_show newPassword">
                <i class='bx bx-show-alt'></i>
            </div>
            <div class="login_input_hidden newPassword">
                <i class='bx bx-low-vision'></i>
            </div>
        </div>
        <div class="form_fill_new_password_content_input renewPassword">
            <input type="password" placeholder="Nhập lại mật khẩu mới" name="renew_password">
            <div class="login_input_show renewPassword">
                <i class='bx bx-show-alt'></i>
            </div>
            <div class="login_input_hidden renewPassword">
                <i class='bx bx-low-vision'></i>
            </div>
        </div>
        <div class="form_fill_new_password_content_btn">
            <button type="submit" class="btn btn-primary">Tiếp tục</button>
        </div>
        <div class="form_fill_new_password_content_back">
            <a href="/profile_user/">Quay lại</a>
        </div>
    </form>
</div>
</body>
</html>
