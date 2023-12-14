<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="temp" value="0"/>
<body>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <button id="btn_create" class="btn btn-sm btn-primary" onclick="create()"> Thêm giỏ hàng</button>
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
                    <tbody class="row_cart">
                    <c:forEach var="i_cart" items="${listCartUser}">
                        <c:if test="${i_cart.active == true}">
                            <tr class="rowCart${temp}">
                                <td>
                                    <div class="row_data1${temp}">
                                            ${i_cart.name}
                                    </div>
                                    <form action="/cart/updateCart/${i_cart.id}" method="post"
                                          class="form_update${temp}" style="display: none;">
                                        <input type="text" value="${i_cart.name}" name="nameCart"/>
                                        <input type="submit" value="Thay đổi">
                                        <div class="update_cancel" style="margin-top:10px;">
                                            <button class="btn btn-sm btn-primary" onclick="cancel${temp}()">Hủy
                                            </button>
                                        </div>
                                    </form>

                                </td>
                                <td class="text-center">${countProductByCartID.get(temp)} </td>

                                <td>${totalPriceByCartID.get(temp)} VNĐ</td>

                                <td class="text-center"><a href="/cart/${i_cart.id}">Xem chi tiết</a></td>
                                <td class="text-right">
                                    <button class="btn btn-sm btn-primary" onclick="update${temp}()">Sửa</button>
                                    <a href="/cart/delete_cart/${i_cart.id}" class="btn btn-sm btn-danger">Xóa</a>
                                    <a class="btn btn-sm btn-primary" href="/order_cart/${i_cart.id}">Thanh toán</a>

                                </td>
                                <script>
                                    function update${temp}(){
                                        var text = document.querySelector(".row_data1${temp}");
                                        var form = document.querySelector(".form_update${temp}");
                                        text.style.display = "none";
                                        form.style.display = "block";
                                    }
                                    function cancel${temp}(){
                                        var text = document.querySelector(".row_data1${temp}");
                                        var form = document.querySelector(".form_update${temp}");
                                        text.style.display = "block";
                                        form.style.display = "none";
                                    }

                                </script>
                                <c:set var="temp" value="${temp+1}"/>
                            </tr>

                        </c:if>
                        <c:if test="${i_cart.active==false}">
                            <c:set var="temp" value="${temp+1}"/>
                        </c:if>
                    </c:forEach>
                    </tbody>
                    <script>
                        function create() {
                            row_cart = document.querySelector(".row_cart");
                            row_cart.innerHTML += '<tr class="rowCart${temp+1}"> <td> <form action="/cart/addCart" method="post"> <input type="text" name="nameNewCart"> <button type="submit" class="btn btn-primary">Thêm giỏ hàng</button> </form> </td> <td class="text-center"><button class="btn btn-danger" onclick="cancel_add()">Hủy</button></td> <td></td> <td></td> <td></td><td></td> </tr>';
                        }

                        function cancel_add() {
                            row_cart = document.querySelector(".rowCart${temp+1}");
                            row_cart.remove();

                        }
                    </script>
                </table>
            </div>
        </div>

    </div>
</div>

</body>

