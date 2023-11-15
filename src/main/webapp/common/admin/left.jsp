<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<div id="sidebar" class="d-flex flex-column flex-shrink-0 py-3 bg-light min-vh-100 open">
	<a href="/"
		class="d-flex align-items-center mb-3 mb-md-0 mx-md-auto link-dark text-decoration-none">
		<!-- <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg> -->
		<img src="<c:url value="/templates/logo.jpg"/>" class="rounded-circle" alt="" width="100px"
		height="auto"> <span class="fs-4">OriShop</span>
	</a>
	<hr>
	<ul class="nav nav-pills flex-column mb-auto text-nowrap">
		<li class="nav-item"><a href="<c:url value="/admin" />" class="nav-link ${active=='home' ? 'active' : 'link-dark'}"
			aria-current="page"> <i class="fa-solid fa-house"></i> <!-- <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg> -->
				Trang chủ
		</a></li>
		<li><a href="<c:url value="/admin/brand" />" class="nav-link ${active=='brand' ? 'active' : 'link-dark'}"> <i
				class="fa-solid fa-gauge"></i> <!-- <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg> -->
				Nhãn hiệu
		</a></li>
		<li><a href="#" class="nav-link link-dark"> <!-- <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg> -->
				<i class="fa-solid fa-money-bill"></i> Đơn hàng
		</a></li>
		<li><a href="<c:url value="/admin/product" />" class="nav-link ${active=='product' ? 'active' : 'link-dark'}"> <i
				class="fa-solid fa-shop"></i> <!-- <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"></use></svg> -->
				Sản phẩm
		</a></li>
		<li><a href="#" class="nav-link link-dark"> <i
				class="fa-solid fa-address-book"></i> <!-- <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg> -->
				Khách hàng
		</a></li>
	</ul>
	<hr>
	<div class="dropdown">
		<a href="#"
			class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle"
			id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
			<img src="https://github.com/mdo.png" alt="" width="32" height="32"
			class="rounded-circle me-2"> <strong>mdo</strong>
		</a>
		<ul class="dropdown-menu text-small shadow"
			aria-labelledby="dropdownUser2">
			<li><a class="dropdown-item" href="#">New project...</a></li>
			<li><a class="dropdown-item" href="#">Settings</a></li>
			<li><a class="dropdown-item" href="#">Profile</a></li>
			<li><hr class="dropdown-divider"></li>
			<li><a class="dropdown-item" href="#">Sign out</a></li>
		</ul>
	</div>
</div>