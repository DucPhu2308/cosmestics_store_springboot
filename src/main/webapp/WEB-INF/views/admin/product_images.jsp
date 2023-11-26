<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<div class="container">
    <h2 class="display-6 my-3">Ảnh của <b>${product.name}</b> </h2>
	<c:if test="${message != null}">

		<div class="alert alert-primary alert-dismissible" role="alert">

			<i>${message}</i>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>

	</c:if>
	<c:if test="${error != null}">

		<div class="alert alert-danger alert-dismissible" role="alert">

			<i>${error}</i>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>

	</c:if>
    <button data-bs-toggle="modal" data-bs-target="#insertModal"
		data-bs-action="Thêm loại hàng" type="button"
		class="btn btn-primary createbtn">
		<i class="fa-solid fa-plus"></i> <span>Thêm ảnh</span>
	</button>
</div>