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
			<div class="chart">
				<canvas id="revenueChart"></canvas>
			</div>
			 <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
			<script>
				var ctx = document.getElementById('revenueChart').getContext('2d');
				var chart = new Chart(ctx, {
					type : 'line',
					data : {
						labels : ${revenueByMonth.keySet()},
						datasets : [ {
							label : 'Doanh thu',
							backgroundColor : 'rgb(255, 99, 132)',
							borderColor : 'rgb(255, 99, 132)',
							data : ${revenueByMonth.values()}
						} ]
					},
					options : {}
				});
			</script>
		</section>
		<section>
			<div class="title">
				<i class="fa-regular fa-message"></i> <span class="text">Đánh
					giá mới</span>
			</div>
		</section>
	</div>
</body>
</html>