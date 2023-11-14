<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="display-6 my-3">Sản phẩm</h2>
		<button data-bs-toggle="modal" data-bs-target="#insertModal"
			data-bs-action="Thêm sản phẩm" type="button" class="btn btn-primary createbtn">
			<i class="fa-solid fa-plus"></i> <span>Thêm sản phẩm</span>
		</button>
		<div class="table-responsive">
			<table style="margin: 10px 5px;" id="table" class="table-striped table align-middle bg-white">
				<thead class="table-dark">
					<tr style="font-weight: bold">
						<th>ID</th>
						<th>Tên</th>
						<th>Giá</th>
						<th style="width: 280px;">Mô tả</th>
						<th>Nhãn hiệu</th>
						<th>Loại hàng</th>
						<th>SL bán</th>
						<th>SL tồn</th>
						<th>Trạng thái</th>
						<th>Ngày thêm</th>
						<th style="width: 200px;">Tác vụ</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Tên Sản phẩm</td>
						<td>100</td>
						<td>ẳetg hwnk ljfnhvgk lnlkjwnr lffeWdfsf sdfsd fsdfs</td>
						<td>dasfgsdfg</td>
						<td>adsfads</td>
						<td>1</td>
						<td>1</td>
						<td><span class="badge text-bg-success">Đang bán</span></td>
						<td>11/11/11</td>
						<td>
							<a class="btn btn-outline-info">
								<i class="fa-solid fa-circle-info"></i>
							</a> 
							<a data-bs-toggle="modal" data-bs-target="#insertModal"
			data-bs-action="Sửa sản phẩm" class="btn btn-outline-warning editbtn">
								<i class="fa-solid fa-pen-to-square"></i> 
							</a>
							<a class="btn btn-outline-success">
								<i class="fa-solid fa-tag"></i>
							</a>
							<a class="btn btn-outline-danger">
								<i class="fa-solid fa-ban"></i>
							</a>
							<a class="btn btn-outline-danger">
								<i class="fa-solid fa-trash"></i>
							</a>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Tên Sản phẩm</td>
						<td>100</td>
						<td>ẳetg hwnk ljfnhvgk lnlkjwnr lffeWdfsf sdfsd fsdfs</td>
						<td>dasfgsdfg</td>
						<td>adsfads</td>
						<td>1</td>
						<td>1</td>
						<td><span class="badge text-bg-success">Đang bán</span></td>
						<td>11/11/11</td>
						<td>
							<a class="btn btn-outline-info">
								<i class="fa-solid fa-circle-info"></i>
							</a> 
							<a data-bs-toggle="modal" data-bs-target="#insertModal"
			data-bs-action="Sửa sản phẩm" class="btn btn-outline-warning editbtn">
								<i class="fa-solid fa-pen-to-square"></i> 
							</a>
							<a class="btn btn-outline-success">
								<i class="fa-solid fa-tag"></i>
							</a>
							<a class="btn btn-outline-danger">
								<i class="fa-solid fa-ban"></i>
							</a>
							<a class="btn btn-outline-danger">
								<i class="fa-solid fa-trash"></i>
							</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 		Insert modal -->
		<div class="modal fade" id="insertModal" tabindex="-1"
			aria-labelledby="insertModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="insertModalLabel">New
							message</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form>
							<div class="row">
								<div class="col-md-6">
									<label for="recipient-name" class="col-form-label">ID:</label> 
									<input readonly type="text" class="form-control" id="id">
								</div>
								<div class="col-md-6 ms-auto">
									<label for="recipient-name" class="col-form-label">Tên sản
									phẩm:</label> <input type="text" class="form-control" id="name">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label for="recipient-name" class="col-form-label">Giá:</label>
									<input type="number" class="form-control" id="price">
								</div>
								<div class="col-md-6 ms-auto">
									<label for="recipient-name" class="col-form-label">Số
										lượng tồn:</label> <input type="number" class="form-control"
										id="stock">
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-6">
									<label for="recipient-name" class="col-form-label">Nhãn
										hiệu:</label> <select class="form-control" name="categoryID">
										<%-- 									<c:forEach var="item" items="${listcate}"> --%>
										<option value="test">test</option>
										<%-- 										/c:forEach> --%>
									</select>
								</div>
								<div class="col-md-6 ms-auto">
									<label for="recipient-name" class="col-form-label">Loại
										hàng:</label> <select class="form-control" name="categoryID">
										<%-- 										<c:forEach var="item" items="${listcate}"> --%>
										<option value="test">test</option>
										<%-- 										/c:forEach> --%>
									</select>
								</div>
							</div>

							<div class="mb-3">
								<label for="message-text" class="col-form-label">Mô tả:</label>
								<textarea class="form-control" id="description"></textarea>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Đóng</button>
						<button type="button" class="btn btn-primary">Xác nhận</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 		End Insert modal -->
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
	<script src="https://cdn.datatables.net/responsive/2.5.0/js/dataTables.responsive.min.js"></script>
	<script src="https://cdn.datatables.net/responsive/2.5.0/js/responsive.bootstrap5.min.js"></script>
	
	<script>
		const insertModal = document.getElementById('insertModal')
		insertModal.addEventListener('show.bs.modal', event => {
		  // Button that triggered the modal
		  const button = event.relatedTarget
		  // Extract info from data-bs-* attributes
		  const action = button.getAttribute('data-bs-action')
		  const modalTitle = insertModal.querySelector('.modal-title')
	
		  modalTitle.textContent = action
		  
		})
// 		window.onload = () => {
// 	        $('#insertModal').modal('show');
// 	    }
		const id = document.getElementById('id')
		const price = document.getElementById('price')
		const stock = document.getElementById('stock')
		const name = document.getElementById('name')
		const description = document.getElementById('description')
		 $(document).ready(function(){
		        $('.editbtn').on('click', function(){
		
		            $('#insertModal').modal('show');
		            $tr =$(this).closest('tr');
		            var data= $tr.children("td").map(function(){
		              return $(this).text();
		            }).get();
					console.log(data)
					id.value = data[0]
					name.value = data[1]
					price.value = data[2]
					stock.value = data[7]
					description.value = data[3]
// 					var Imagedata = [];
// 					Imagedata.push($tr.find('img').attr('src'))
// 		            $('#SetImage').attr("src",Imagedata[0]);
					
// 		            $('#title').val(data[0]);
// 		            $('#quantity').val(data[1]);
// 		            $('#size').val(data[2]);
		            
		        });
		        $('.createbtn').on('click', function(){
		    		
		            $('#insertModal').modal('show');
		            $tr =$(this).closest('tr');
		            var data= $tr.children("td").map(function(){
		              return $(this).text();
		            }).get();
					console.log(data)
					id.value = ''
					name.value = ''
					price.value = ''
					stock.value = ''
					description.value = ''
		        });
		    });
		new DataTable('#table', {
				pagingType : 'full_numbers',
				"pageLength" : 5,
				responsive: true,
			});
	</script>
</body>
</html>