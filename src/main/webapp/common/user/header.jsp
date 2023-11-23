<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/16/2023
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.html">
            <img src="<c:url value="/templates/images/logo.jpg"/>"  width="120" alt="logo" class="container_nav_image">
            ORI SHOP
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/category">Categories</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/product">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cart">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact/${productId}">Contact</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="/cart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>

            <c:if test="${sessionScope.user_id != null}">

            <div class="header_action_user">
                <div class="header_action_logo_user">
                    <div class="user_logo">
                        <img src="/templates/images/logo.jpg" width="30" alt="logo">
                    </div>
                    <div class="profile_user">
                        <div class="profile_user_info">
                            <div class="profile_user_info_col3">
                                <img src="/templates/images/logo.jpg" width="30" alt="logo">
                            </div>
                            <div class="profile_user_info_col6">
                                <span>Nicolas Tesla </span>
                            </div>
                        </div>
                        <div class="profile_user_col">
                            <a href="">Hồ sơ của tui</a>
                        </div>
                        <div class="profile_user_col">
                            <a href="">Đơn đặt hàng</a>
                        </div>
                        <div class="profile_user_col">
                            <a href="/checkout">Đăng xuất</a>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>
            <c:if test="${sessionScope.user_id == null}">
                <div class="header_action_user">
                    <a href="/login/">Đăng nhập</a>
                    <a href="/register/">Đăng ký</a>
                </div>
            </c:if>
        </div>

    </div>
</nav>

