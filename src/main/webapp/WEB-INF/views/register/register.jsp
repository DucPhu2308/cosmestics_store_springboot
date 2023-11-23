<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link rel='stylesheet' href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
    <link rel="stylesheet" href="<c:url value="/templates/login/css/login.css"/>" >
    <link rel="stylesheet" href="<c:url value="/templates/login/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/templates/user/css/style.css"/>">
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="container image">
            <a class="navbar-brand" href="/">
                <img src="<c:url value="/templates/images/logo.jpg" />" width="120" alt="logo">
            </a>
            <p>Đăng ký</p>
        </div>


        <div class="container_nav_help">
            <a href="#">Bạn cần trợ giúp? </a>
        </div>


    </div>
</nav>

<div class="container_body">

    <div class="form_login register">
        <h4>Đăng ký</h4>
        <form:form method="post" action="register2" modelAttribute="new_user">
            <div class="mb-3">
                <form:input type="text" class="form-control" path="phone"
                       placeholder="Email/Số điện thoại"/>
                <p>${error}</p>
            </div>
            <div class="mb-3">
                <div class="mb-3-password reg">
                    <form:input type="password" class="form-control" path="passwordHashed" placeholder="Mật khẩu"/>
                    <div class="signup_input_show">
                        <i class='bx bx-show-alt'></i>
                    </div>
                    <div class="signup_input_hidden">
                        <i class='bx bx-low-vision'></i>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <div class="form-login-btn">
                    <input type="submit" class="btn btn-primary" value="Đăng ký"/>
                </div>
                <div class="mb-3 form-check">
                    <div class="tille-signup">
                        <p>HOẶC</p>
                    </div>
                    <div class="signup_social">
                        <a href="" class="btn btn-facebook"><i class="fa fa-facebook" aria-hidden="true"></i>
                            Facebook</a>
                        <a href="" class="btn btn-google"><i class="fa fa-google" aria-hidden="true"></i> Google</a>
                    </div>
                    <div class="signup_policy">
                        <p>Bằng việc đăng ký, bạn đã đồng ý với shop về
                            <a href="">Điều khoản dịch vụ</a> &
                            <a href="">Chính sách bảo mật</a>
                        </p>
                    </div>
                    <div class="signup_not_have_account">
                        <p>Bạn đã có tài khoản. Hãy đăng nhập
                            <a href="/login/">tại đây</a>
                        </p>
                    </div>

                </div>
            </div>
        </form:form>
    </div>

</div>


<script src="<c:url value="/templates/login/js/login.js"/>" ></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</body>

<footer class="text-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-4 col-xl-3">
                <h5>About</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <p class="mb-0">
                    Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant
                    impression.
                </p>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                <h5>Informations</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><a href="">Link 1</a></li>
                    <li><a href="">Link 2</a></li>
                    <li><a href="">Link 3</a></li>
                    <li><a href="">Link 4</a></li>
                </ul>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                <h5>Others links</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><a href="">Link 1</a></li>
                    <li><a href="">Link 2</a></li>
                    <li><a href="">Link 3</a></li>
                    <li><a href="">Link 4</a></li>
                </ul>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3">
                <h5>Contact</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><i class="fa fa-home mr-2"></i> My company</li>
                    <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                    <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                    <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                </ul>
            </div>
            <div class="col-12 copyright mt-3">
                <p class="float-left">
                    <a href="#">Back to top</a>
                </p>
                <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a
                        href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v.
                        1.0</span></p>
            </div>
        </div>


    </div>
</footer>


</html>
