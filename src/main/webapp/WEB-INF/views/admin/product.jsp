<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <div class="container">
      <h2 class="display-6 my-3">Sản phẩm</h2>
      <c:if test="${message != null}">
        <div class="alert alert-primary alert-dismissible" role="alert">
          <i>${message}</i>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </c:if>
      <c:if test="${error != null}">
        <div class="alert alert-danger alert-dismissible" role="alert">
          <i>${error}</i>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </c:if>
      <button
        data-bs-toggle="modal"
        data-bs-target="#insertModal"
        data-bs-action="Thêm sản phẩm"
        type="button"
        class="btn btn-primary createbtn"
      >
        <i class="fa-solid fa-plus"></i> <span>Thêm sản phẩm</span>
      </button>
      <div class="table-responsive">
        <table
          style="margin: 10px 5px"
          id="table"
          class="table-striped table align-middle bg-white"
        >
          <thead class="table-dark">
            <tr style="font-weight: bold">
              <th>ID</th>
              <th>Tên</th>
              <th>Giá</th>
              <th style="width: 240px">Mô tả</th>
              <th>Nhãn hiệu</th>
              <th>Loại hàng</th>
              <th>SL bán</th>
              <th>SL tồn</th>
              <th>Trạng thái</th>
              <th>Ngày thêm</th>
              <th style="width: 160px">Tác vụ</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="i" items="${list}">
              <tr>
                <td>${i.id }</td>
                <td>${i.name }</td>
                <td>${i.price }</td>
                <td>${i.description }</td>
                <td>${i.brand.name }</td>
                <td>${i.category.name }</td>
                <td>${i.soldCount }</td>
                <td>${i.stock}</td>
                <td>
                  <c:if test="${i.available}">
                    <span class="badge text-bg-success">Đang bán</span>
                  </c:if>
                  <c:if test="${!i.available}">
                    <span class="badge text-bg-danger">Ngừng bán</span>
                  </c:if>
                </td>
				<!-- format created date -->
				<td><fmt:formatDate value="${i.createdDate}" pattern="dd/MM/yyyy"/></td>
                <td>
                  <a class="btn btn-outline-info">
                    <i class="fa-solid fa-circle-info"></i>
                  </a>
                  <a
                    data-bs-toggle="modal"
                    data-bs-target="#insertModal"
                    data-bs-action="Sửa sản phẩm"
                    class="btn btn-outline-warning editbtn"
                  >
                    <i class="fa-solid fa-pen-to-square"></i>
                  </a>
                  <a class="btn btn-outline-success">
                    <i class="fa-solid fa-tag"></i>
                  </a>
                  <a class="btn btn-outline-danger"
				  	data-bs-toggle="modal"
                    data-bs-target="#warningModal"
					data-bs-id="${i.id }"
					>
                    <i class="fa-solid fa-trash"></i>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- 		Insert modal -->
      <div
        class="modal fade"
        id="insertModal"
        tabindex="-1"
        aria-labelledby="insertModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog modal-dialog-scrollable modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="insertModalLabel">
                New message
              </h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <form:form
              modelAttribute="product"
              method="post"
              action="product/save"
            >
              <div class="modal-body">
                <div class="mb-3">
                  <div class="form-check form-switch">
                    <label class="form-check-label">Trạng thái</label>
                    <form:checkbox path="available" class="form-check-input" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label for="recipient-name" class="col-form-label"
                      >ID:</label
                    >
                    <form:input
                      path="id"
                      readonly="true"
                      type="text"
                      class="form-control"
                      id="id"
                    />
                  </div>
                  <div class="col-md-6 ms-auto">
                    <label for="recipient-name" class="col-form-label"
                      >Tên sản phẩm:</label
                    >
                    <form:input
                      path="name"
                      type="text"
                      class="form-control"
                      id="name"
                    />
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <label for="recipient-name" class="col-form-label"
                      >Giá:</label
                    >
                    <form:input
                      path="price"
                      type="number"
                      step="0.01"
                      class="form-control"
                      id="price"
                    />
                  </div>
                  <div class="col-md-6 ms-auto">
                    <label for="recipient-name" class="col-form-label"
                      >Số lượng tồn:</label
                    >
                    <form:input
                      path="stock"
                      type="number"
                      class="form-control"
                      id="stock"
                    />
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-6">
                    <label for="recipient-name" class="col-form-label"
                      >Nhãn hiệu:</label
                    >
                    <form:select path="brand" class="form-control" id="brand">
                      <form:options
                        items="${brands}"
                        itemValue="id"
                        itemLabel="name"
                      />
                    </form:select>
                  </div>
                  <div class="col-md-6 ms-auto">
                    <label for="recipient-name" class="col-form-label"
                      >Loại hàng:</label
                    >
                    <form:select
                      path="category"
                      class="form-control"
                      id="category"
                    >
                      <form:options
                        items="${categories}"
                        itemValue="id"
                        itemLabel="name"
                      />
                    </form:select>
                  </div>
                </div>

                <div class="mb-3">
                  <label for="message-text" class="col-form-label"
                    >Mô tả:</label
                  >
                  <form:textarea
                    path="description"
                    class="form-control"
                    id="description"
                  ></form:textarea>
                </div>
                <div class="modal-footer">
                  <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Đóng
                  </button>
                  <button type="submit" class="btn btn-primary">
                    <i class="fa-solid fa-floppy-disk"></i>
                    <span>Xác nhận</span>
                  </button>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
      <!-- 		End Insert modal -->
	  <!-- 	Delete warning modal -->
	<div class="modal fade" id="warningModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		  <div class="modal-content">
			<div class="modal-header">
			  <h1 class="modal-title fs-5" id="exampleModalLabel">Cảnh báo</h1>
			  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
			  Chỉ có thể thực hiện xóa nếu đối tượng chưa được làm khóa ngoại.
			  Mặt khác thao tác này không thể hoàn tác. <br>
			  Bạn muốn tiếp tục?
			</div>
			<div class="modal-footer">
			  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
			  <a id="modalDeleteBtn" type="button" class="btn btn-danger">
				  <i class="fa-solid fa-trash"></i>
				  <span>Tiếp tục</span>
			  </a>
			</div>
		  </div>
		</div>
	  </div>
	  <!-- 	    End Delete warning modal -->
    </div>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.5.0/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.5.0/js/responsive.bootstrap5.min.js"></script>

    <script>
      const insertModal = document.getElementById("insertModal");
      insertModal.addEventListener("show.bs.modal", (event) => {
        // Button that triggered the modal
        const button = event.relatedTarget;
        // Extract info from data-bs-* attributes
        const action = button.getAttribute("data-bs-action");
        const modalTitle = insertModal.querySelector(".modal-title");

        modalTitle.textContent = action;
      });
      const warningModal = document.getElementById('warningModal')
		warningModal.addEventListener('show.bs.modal', event => {
		  // Button that triggered the modal
		  const button = event.relatedTarget
		  // Extract info from data-bs-* attributes
		  const id = button.getAttribute('data-bs-id')
		  const modalDeleteBtn = warningModal.querySelector('#modalDeleteBtn')
		  modalDeleteBtn.href = "product/delete/" + id
		})
      const id = document.getElementById("id");
      const price = document.getElementById("price");
      const stock = document.getElementById("stock");
      const name = document.getElementById("name");
      const description = document.getElementById("description");
      const brand = document.getElementById("brand");
      const category = document.getElementById("category");
      $(document).ready(function () {
        $(".editbtn").on("click", function () {
          function findSelectedValue(select, text) {
            for (let i = 0; i < select.length; i++) {
              if (select.options[i].text === text) {
                return select.options[i].value;
              }
            }
            return null;
          }
          $("#insertModal").modal("show");
          $tr = $(this).closest("tr");
          var data = $tr
            .children("td")
            .map(function () {
              return $(this).text();
            })
            .get();
          id.value = data[0];
          name.value = data[1];
          price.value = data[2];
          stock.value = data[7];
          description.value = data[3];
          brand.value = findSelectedValue(brand, data[4]);
          category.value = findSelectedValue(category, data[5]);
        });
        $(".createbtn").on("click", function () {
          $("#insertModal").modal("show");
          $tr = $(this).closest("tr");
          var data = $tr
            .children("td")
            .map(function () {
              return $(this).text();
            })
            .get();
          console.log(data);
          id.value = "";
          name.value = "";
          price.value = "";
          stock.value = "";
          description.value = "";
        });
      });
      new DataTable("#table", {
        pagingType: "full_numbers",
        pageLength: 5,
        responsive: true,
      });
    </script>
  </body>
</html>
