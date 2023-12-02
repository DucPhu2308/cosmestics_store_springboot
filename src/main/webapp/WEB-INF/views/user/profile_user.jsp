<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    // Lấy giá trị ngày tháng từ một biến hoặc đối tượng khác
    String defaultDate = "2023-12-01";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link rel='stylesheet' href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
    <link rel="stylesheet" href="<c:url value="/templates/login/css/login.css"/>" />
    <link rel="stylesheet" href="<c:url value="/templates/login/css/header.css"/>" />
    <link rel="stylesheet" href="<c:url value="/templates/user/css/style.css"/>" />
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="container image">
            <a class="navbar-brand" href="/">
                <img src="<c:url value="/templates/images/logo.jpg"/>"  width="120" alt="logo">
            </a>
            <p>Hồ sơ của tôi</p>
        </div>


        <div class="container_nav_help">
            <a href="#">Bạn cần trợ giúp? </a>
        </div>


    </div>
</nav>

<div class="container_body">

    <div class="form_login profile_user_container">
        <h3>Hồ sơ của tôi</h3>
        <form:form method="post" action="update_user" modelAttribute="user" enctype="multipart/form-data">
            <div class="detail_form_info">
                <div class="detail_info">
                    <div class="detail_author">
                        <label >Họ và tên lót:</label>
                        <form:input type="text" value="${user.firstName}" path="firstName"/>
                    </div>
                    <div class="detail_author">
                        <label >Tên:</label>
                        <form:input type="text" value="${user.lastName}" path="lastName"/>
                    </div>
                    <div class="detail_author">
                        <label >Email</label>
                        <form:input type="text" value="${user.email}" path="email"/>
                    </div>
                    <div class="detail_author">
                        <label >Số điện thoại</label>
                        <form:input type="text" value="${user.phone}" path="phone"/>
                    </div>
                    <div class="detail_author">
                        <label >Mật khẩu</label>
                        <input type="password" value="${user.passwordHashed}" disabled>
                    </div>

                    <div class="detail_author">
                        <label >Giới tính</label>
                        <div class="checkoption">
                            <input type="radio" id="male" name="option_gender" value="male" >
                            <label >Nam</label>
                            <input type="radio" id="female" name="option_gender" value="female">
                            <label >Nữ</label>
                        </div>

                    </div>
                    <script>
                        if((${user.gender})===true){
                            document.getElementById("male").checked=true;
                        }
                        else{
                            if((${user.gender})===false){
                                document.getElementById("female").checked=true;
                            }
                        }

                    </script>
                    <div class="detail_author">
                        <label >Ngày sinh</label>
                        <input type="date" name="dob_user" value="${dob}" id="dob">
                    </div>
                </div>

                <div class="detail_info_image">
                    <div class="detail_image_user">
                        <c:if test="${user.avatarLink == null}">
                            <img src="<c:url value="/templates/images/account.png"/>" alt="" id="imageElement">
                        </c:if>
                        <c:if test="${user.avatarLink != null}">
                            <img src="<c:url value="/templates/images/${user.avatarLink}"/>" alt="" id="imageElement">
                        </c:if>
                        <input path="avatarLink" type="file" id="image_user" style="display: none;" name="image_user">
                        <button type="button" onclick="document.getElementById('image_user').click();">Chọn ảnh </button>
                    </div>
                    <script>
                        const fileInput = document.getElementById('image_user');
                        const imageElement = document.getElementById('imageElement');

                        fileInput.addEventListener('change', function() {
                            const file = fileInput.files[0]; // Lấy tệp tin đầu tiên từ thẻ input

                            if (file) {
                                const reader = new FileReader();

                                reader.onload = function(e) {
                                    imageElement.src = e.target.result; // Gán dữ liệu hình ảnh cho thẻ img
                                };

                                reader.readAsDataURL(file); // Đọc tệp tin dưới dạng dữ liệu URL
                            } else {
                                // Xử lý khi không có tệp tin nào được chọn
                                alert('Vui lòng chọn một tệp tin hình ảnh.');
                                imageElement.src = ''; // Xóa hình ảnh nếu không có tệp tin nào
                            }
                        });
                    </script>
                </div>

            </div>

            <div class="detail_info_submit">
                <input type="submit" class="btn-primary" value="Lưu">
                <a href="/" class="btn-danger">Thoát</a>
            </div>

        </form:form>

    </div>






</div>


<script src="login.js"></script>
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
