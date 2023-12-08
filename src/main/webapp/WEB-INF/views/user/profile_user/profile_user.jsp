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
<body>
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
                        <form:input type="email" value="${user.email}" path="email"/>
                    </div>
                    <div class="detail_author">
                        <label >Số điện thoại</label>
                        <form:input type="text" value="${user.phone}" path="phone"/>
                    </div>
                    <div class="detail_author">
                        <label >Mật khẩu</label>
                        <input type="password" value="${user.passwordHashed}" disabled>
                    </div>
                    <a class="btn-profile-change-password" href="/profile_user/change_password" style="border:1px solid white">Thay đổi mật khẩu</a>
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

</body>

</html>
