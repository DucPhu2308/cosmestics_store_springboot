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
		<h2 class="display-6 my-3">Xin chào, User</h2>
		<section>
			<div class="title">
				<i class="fa-solid fa-gauge"></i> <span class="text">Tổng
					quan</span>
			</div>
			<div class="boxes">
				<div class="box box1">
					<i class="fa-solid fa-dollar-sign"></i> <span class="text">Doanh
						thu</span> <span class="number">$${revenue}</span>
				</div>

				<div class="box box2">
					<i class="fa-solid fa-receipt"></i> <span class="text">Số đơn hàng</span> 
					<span class="number">${orderCount}</span>
				</div>
				<div class="box box3">
					<i class="fa-solid fa-user"></i> <span class="text">Người
						dùng mới</span> <span class="number">100,123</span>
				</div>
				<div class="box box4">
					<i class="fa-solid fa-star"></i> <span class="text">Lượt
						đánh giá</span> <span class="number">333,333</span>
				</div>
			</div>
		</section>
		<section>
			<div class="title">
				<i class="fa-regular fa-heart"></i> <span class="text">Biểu đồ doanh thu</span>
			</div>
			
		</section>
		<section>
			<div class="title">
				<i class="fa-regular fa-message"></i> <span class="text">Đánh
					giá mới</span>
			</div>
			<div class="table">
				<table>
					<thead>
						<tr>
							<th>Người dùng</th>
							<th>Sản phẩm</th>
							<th>Đánh giá</th>
							<th>Thời gian</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Nguyễn Văn A</td>
							<td>iPhone 12 Pro Max</td>
							<td>5 sao</td>
							<td>12/12/2020</td>
						</tr>
						<tr>
							<td>Nguyễn Văn A</td>
							<td>iPhone 12 Pro Max</td>
							<td>5 sao</td>
							<td>12/12/2020</td>
						</tr>
						<tr>
							<td>Nguyễn Văn A</td>
							<td>iPhone 12 Pro Max</td>
							<td>5 sao</td>
							<td>12/12/2020</td>
						</tr>
						<tr>
							<td>Nguyễn Văn A</td>
							<td>iPhone 12 Pro Max</td>
							<td>5 sao</td>
							<td>12/12/2020</td>
						</tr>
						<tr>
							<td>Nguyễn Văn A</td>
							<td>iPhone 12 Pro Max</td>
							<td>5 sao</td>
							<td>12/12/2020</td>
						</tr>
					</tbody>
				</table>
		</section>
	</div>
</body>
</html>