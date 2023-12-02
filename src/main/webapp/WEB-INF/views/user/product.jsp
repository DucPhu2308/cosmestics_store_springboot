<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp"%>


<body>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE PRODUCT</h1>
        <p class="lead text-muted mb-0">Le Lorem Ipsum est simplement du
            faux texte employé dans la composition et la mise en page avant
            impression. Le Lorem Ipsum est le faux texte standard de
            l'imprimerie depuis les années 1500...</p>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item"><a href="/category">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Product</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
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
    <div class="row">
        <!-- Image -->
        <div class="col-12 col-lg-6">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <div style="width: 100%; height: 500px;" id="carouselExample" class="carousel carousel-dark slide">
                        <div class="carousel-inner">
                            <c:forEach items="${product.images}" var="image" varStatus="status">
                                <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                                        <%-- <div class="col-md-3"> --%>
                                    <img src="<c:url value="/templates/images/${image.imageLink}"/>" style="height: 500px;" class="d-block w-100" alt="...">

                                </div>
                            </c:forEach>


                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
<%--                    <a href="" data-toggle="modal" data-target="#productModal">--%>
<%--                        <img src="<c:url value="/templates/images/${product.images}"/>"  width="120" alt="logo" class="container_nav_image">--%>
<%--                        --%>
<%--                        <p class="text-center">Zoom</p>--%>
<%--                    </a>--%>
                </div>
            </div>
        </div>

        <!-- Add to cart -->
        <div class="col-12 col-lg-6 add_to_cart_block">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <c:if test="${discount == 0}">
                        <p class="price">${product.price} $</p>
                    </c:if>
                    <c:if test="${discount != 0}">
                        <p class="price">${product_discounted} $</p>
                        <p class="price_discounted">${product.price} $</p>
                        <label>Chương trình áp dụng giảm giá với sản phẩm này từ ngày ${discountStart} đến ngày ${discountEnd}</label>
                    </c:if>

                    <sec:authorize access="hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')" var="isAuthenticated">
                    </sec:authorize>
                    <c:if test="${isAuthenticated}">
                        <form:form method="post" action="/product/${productId}/product_to_cart" modelAttribute="cart_product">

                            <div class="form-group">
                                <div class="form-group">
                                    <label for="colors">Chọn giỏ hàng</label>
                                    <form:select class="custom-select" id="colors" path="cart">
                                        <c:forEach var="i_cart" items="${listCart}">
                                            <c:if test="${i_cart.active == true}">
                                                <option value="${i_cart.id}">${i_cart.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <a href="/cart">Thêm giỏ hàng</a></br>
                                <label>Quantity :</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <form:button type="button"
                                                class="quantity-left-minus btn btn-danger btn-number"
                                                data-type="minus" data-field="">
                                            <i class="fa fa-minus"></i>
                                        </form:button>
                                    </div>
                                    <form:input type="text" class="form-control" id="quantity" name="quantity"
                                                path="quantity" min="1" max="100" value="1"/>
                                    <div class="input-group-append">
                                        <form:button type="button"
                                                class="quantity-right-plus btn btn-success btn-number"
                                                data-type="plus" data-field="">
                                            <i class="fa fa-plus"></i>
                                        </form:button>
                                    </div>
                                </div>
                            </div>
                            <input type="submit" value="Thêm vào giỏ hàng" class="btn btn-success btn-lg btn-block text-uppercase">
    <%--                        <a href="cart.html"--%>
    <%--                           class="btn btn-success btn-lg btn-block text-uppercase"> <i--%>
    <%--                                class="fa fa-shopping-cart"></i> Add To Cart--%>
    <%--                        </a>--%>
                        </form:form>
                    </c:if>
                    <c:if test="${!isAuthenticated}">
                        <p class="text-center">Vui lòng đăng nhập để thêm vào giỏ hàng</p>
                    </c:if>
                    <div class="product_rassurance">
                        <ul class="list-inline">
                            <li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br/>Fast
                                delivery
                            </li>
                            <li class="list-inline-item"><i
                                    class="fa fa-credit-card fa-2x"></i><br/>Secure payment
                            </li>
                            <li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br/>+33
                                1 22 54 65 60
                            </li>
                        </ul>
                    </div>
                    <div class="reviews_product p-3 mb-2 ">
                        3 reviews <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                            class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                            class="fa fa-star"></i> (4/5) <a class="pull-right"
                                                             href="#reviews">View all reviews</a>
                    </div>
                    <div class="datasheet p-3 mb-2 bg-info text-white">
                        <a href="" class="text-white"><i class="fa fa-file-text"></i>
                            Download DataSheet</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <!-- Description -->
        <div class="col-12">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-align-justify"></i> Description
                </div>
                <div class="card-body">
                    <pre style="font-family: 'Be VietNam Pro', 'sans-serif'; font-size: 20px; font-weight: 500;">${product.description}</pre>

                </div>
            </div>
        </div>

        <div class="container mt-3">
            <div class="row">
                <div class="col-sm">
                    <div class="card">
                        <div class="card-header bg-primary text-white text-uppercase">
                            <i class="fa fa-star"></i> Sản phẩm cùng hãng
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <c:forEach var="i" items="${listProductBrand}" varStatus="status">
                                    <c:if test="${status.index <4}">
                                        <c:if test="${i.id != productId}">
                                            <div class="col-sm">
                                                <div class="card">
                                                    <c:if test="${i.images.size() > 0}">
                                                        <img class="card-img-top" src="<c:url value="/templates/images/${i.images[0].imageLink}"/>" alt="Card image cap">
                                                    </c:if>
                                                    <c:if test="${i.images.size() == 0}">
                                                        <img class="card-img-top" src="<c:url value="/templates/images/no-image.png"/>" alt="Card image cap">
                                                    </c:if>
                                                    <div class="card-body">
                                                        <h4 class="card-title"><a href="/product/${i.id}" title="View Product">${i.name}</a></h4>
                                                        <p class="card-text">${i.description}</p>
                                                        <div class="row">
                                                            <div class="col">
                                                                <p class="btn btn-danger btn-block">${i.price}VNĐ</p>
                                                            </div>
                                                            <div class="col">
                                                                <a href="cart.html" class="btn btn-success btn-block">Add to cart</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Reviews -->
        <div class="col-12" id="reviews">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-comment"></i> Reviews
                </div>
                <div class="review">
                <c:if test="${isAuthenticated}">
                    <form:form class="post-review" method="post" action="/product/${productId}/review1" modelAttribute="post_review">
                        <div class="post-review-user">
                            <img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                 alt="avatar">
                            <span class="ml-2">POSTER_NAME</span>
                        </div>
                        <h4 class="text-uppercase">Give your review:</h4>
                        <div id="rating">
                            <input path="rating" type="radio" id="star5" name="rating" value="5" />
                            <label class = "full" for="star5" title="Awesome - 5 stars"></label>

                            <input type="radio" id="star4" name="rating" value="4" />
                            <label class = "full" for="star4" title="Pretty good - 4 stars"></label>

                            <input type="radio" id="star3" name="rating" value="3" />
                            <label class = "full" for="star3" title="Meh - 3 stars"></label>

                            <input type="radio" id="star2" name="rating" value="2" />
                            <label class = "full" for="star2" title="Kinda bad - 2 stars"></label>

                            <input type="radio" id="star1" name="rating" value="1" />
                            <label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                        </div>
                        <form:textarea path="content" class="form-control animated" cols="5" id="new-review" name="new-review"
                                  placeholder="Enter your review here..." rows="5"></form:textarea>

                        <input type="submit" value="Đăng bình luận" class="btn-post-review">

                    </form:form>
                </c:if>
                <c:if test="${!isAuthenticated}">
                    <p>Vui lòng đăng nhập để đánh giá sản phẩm</p>
                </c:if>
                </div>

                <h3>Tất cả các bình luận</h3>

                <div class="card-body">
                    <c:forEach var="i" items="${product_review}">
                        <div class="review">
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            <meta itemprop="datePublished" content="01-01-2016">
                            ${i.published}<span class="fa fa-star"></span> <span
                                class="fa fa-star"></span> <span class="fa fa-star"></span> <span
                                class="fa fa-star"></span> <span class="fa fa-star"></span> ${i.user.firstName} ${i.user.lastName}
                            <p class="blockquote">
                            <p class="mb-0">${i.content}</p>
                            <hr>
                        </div>
                    </c:forEach>

                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <meta itemprop="datePublished" content="01-01-2016">
                        January 01, 2018 <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span> <span
                            class="fa fa-star" aria-hidden="true"></span> <span
                            class="fa fa-star" aria-hidden="true"></span> <span
                            class="fa fa-star" aria-hidden="true"></span> by Paul Smith
                        <p class="blockquote">
                        <p class="mb-0">Lorem ipsum dolor sit amet, consectetur
                            adipiscing elit. Integer posuere erat a ante.</p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
    //Plus & Minus for Quantity product
    $(document).ready(function(){
        var quantity = 1;

        $('.quantity-right-plus').click(function(e){
            e.preventDefault();
            var quantity = parseInt($('#quantity').val());
            $('#quantity').val(quantity + 1);
        });

        $('.quantity-left-minus').click(function(e){
            e.preventDefault();
            var quantity = parseInt($('#quantity').val());
            if(quantity > 1){
                $('#quantity').val(quantity - 1);
            }
        });

    });
</script>
</body>

