# Xây dựng website bán mỹ phẩm OriShop bằng Spring Boot + JSP/JSTL+ Bootstrap + JPA + SQLServer/MySQL/postgreSQL+Decorator Sitemesh

## Mô tả

Đây là một project web bán mỹ phẩm được xây dựng bằng Spring Boot + JSP/JSTL + Bootstrap + JPA + postgreSQL + Decorator Sitemesh. \
Project này được dùng làm đồ án cuối kỳ môn Lập trình Web trường Đại học Sư phạm Kỹ thuật TP. HCM, GVHD Nguyễn Hữu Trung. \
Xem chi tiết báo cáo và phân công nhiệm vụ trong file bao_cao_web_nhom7.docx

## Các chức năng

1. Phân tích chức năng, CSDL

2. Xây dựng layout trang chủ, module hóa thành phần giao diện

3. Code chức năng

4. Xây dựng Trang chủ

5. Xây dựng Trang hàng hóa

    - Lọc, phân loại hàng hóa.
    - Phân trang hàng hóa.

6. Xây dựng Trang chi tiết hàng hóa

    - Thông tin chi tiết.
    - Hàng cùng loại.
    - Hàng cùng nhà cung cấp.
    - Hàng đã xem

7. Quản lý Thành viên

    - Đăng ký
    - Đăng nhập/Đăng xuất
    - Quên mật khẩu
    - Quản lý tài khoản
    - Quản lý đơn hàng

8. Xử lý Giỏ hàng và Thanh toán

    - Chọn hàng hóa
    - Quản lý (thêm/xóa/sửa) giỏ hàng
    - Đặt hàng
    - Thanh toán kết nối với ngân hàng (ảo).

9. Phần Quản trị (Backend):

    - Quản lý thêm, xóa, sửa Hàng hóa
    - Quản lý thêm, xóa, sửa Hóa đơn
    - Quản lý thêm, xóa, sửa Khách hàng
    - Quản lý Doanh thu
    - Quản lý tài khoản người dùng, Vai trò (Role), Phân quyền
    - Thống kê: Hàng tồn kho, Doanh số từng mặt hàng, theo nhà cung cấp/khách hàng, từngtháng/quý/năm.

## Các yêu cầu cài đặt

- Java 17
- Maven
- Database Server
- Tomcat server

## Cách cài đặt

1. Chạy lệnh sau để tải project về máy:
git clone <https://github.com/DucPhu2308/cosmestics_store_springboot.git>

2. Setup một database (Khuyến khích sử dụng PostgresSQL)

3. Sử dụng IDE ưa thích để build và chạy project

### Lưu ý

Bạn cần thay đổi các thông tin database trong file application.properties
