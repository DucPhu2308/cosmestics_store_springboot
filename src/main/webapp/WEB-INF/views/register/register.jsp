<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/15/2023
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<div class="form_login profile_user_container">
    <h3>Hồ sơ của tôi</h3>
    <form method="post" class="detail_form">
        <div class="detail_form_info">
            <div class="detail_info">
                <div class="detail_author">
                    <label for="">Họ và tên</label>
                    <input type="text">
                </div>
                <div class="detail_author">
                    <label for="">Email</label>
                    <input type="text">
                </div>
                <div class="detail_author">
                    <label for="">Số điện thoại</label>
                    <input type="text">
                </div>

                <div class="detail_author">
                    <label for="">Địa chỉ</label>
                    <input type="text">
                </div>

                <div class="detail_author">
                    <label for="">Giới tính</label>
                    <div class="checkoption">
                        <input type="radio" id="male" name="fav_language" value="1" >
                        <label for="">Nam</label>
                        <input type="radio" id="female" name="fav_language" value="2" >
                        <label for="">Nữ</label>
                    </div>

                </div>


                <div class="detail_author">
                    <label for="">Ngày sinh</label>
                    <input type="date">
                </div>
            </div>

            <div class="detail_info_image">
                <div class="detail_image_user">
                    <img src="account.png" alt="" id="imageElement">
                    <input type="file" id="image_user" style="display: none;">
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
        </div>

    </form>

</div>

</body>

