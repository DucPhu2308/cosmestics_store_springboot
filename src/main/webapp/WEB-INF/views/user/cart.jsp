<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="cartID" value="0"/>

<body>
	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">E-COMMERCE CART</h1>
		</div>
	</section>

	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-select">
					<form action="cart/getProduct" method="post">
						<label >Chọn giỏ hàng:</label>
						<select name="cart_user" >
							<option selected>
								<c:if test="${listCartUser == null}">
									Chưa có giỏ hàng nào
								</c:if>
								<c:if test="${listCartUser != null}">
									<c:forEach var="j" items="${listCartUser}">
										<c:if test="${j.id == sessionScope.cart_id}">
											${j.name}
											<c:set var="cartID" value="${j.id}"/>
										</c:if>
									</c:forEach>
								</c:if>
							</option>

							<c:forEach var="j" items="${listCartUser}">
								<option value="${j.id} ">${j.name}</option>
							</c:forEach>

						</select>
						<button type="submit" class="btn btn-primary">Hiện sản phẩm</button>
					</form>

				</div>
				<form:form method="post" action="/cart/delete_cart/${cartID}">
					<input type="submit" class="btn btn-sm btn-danger" value="Xóa giỏ hàng">
				</form:form>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Product</th>
								<th scope="col">Available</th>
								<th scope="col" class="text-center">Quantity</th>
								<th scope="col" class="text-right">Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${listCartProduct == null}">
								<tr>
									<td colspan="6">Không có sản phẩm nào trong giỏ hàng</td>
								</tr>
							</c:if>
							<c:if test="${listCartProduct != null}">
								<c:forEach var="i" items="${listCartProduct}">
									<tr>
										<td><img src="https://dummyimage.com/50x50/55595c/fff" />
										</td>
										<td>${i.product.name}</td>
										<td>${i.product.stock}</td>
										<td><input class="form-control" type="text" value="${i.quantity}" /></td>
										<td class="text-right">${i.totalPrice} €</td>
										<td class="text-right">
											<form:form method="post" action="/cart/delete/${i.product.id}">
												<input type="submit" class="btn btn-sm btn-danger" value="Xóa">
											</form:form>
										</td>
									</tr>

								</c:forEach>
							</c:if>


							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Sub-Total</td>
								<td class="text-right">
									<c:if test="${totalPrice == null}">
										0 €
									</c:if>
									<c:if test="${totalPrice != null}">
										${totalPrice} €
									</c:if>
								</td>
							</tr>

							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><strong>Total</strong></td>
								<td class="text-right"><strong>${totalPrice} €</strong></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<button class="btn btn-block btn-light" type="submit" formaction="/category">Continue Shopping</button>
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>