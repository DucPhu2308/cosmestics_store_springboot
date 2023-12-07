<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE CATEGORY</h1>
        <p class="lead text-muted mb-0">Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte...</p>
    </div>
</section>

<div class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/55595c/fff" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/a30ca3/fff" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/1443ff/fff" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">
            <div class="card">
                <div class="card-header bg-success text-white text-uppercase">
                    <i class="fa fa-heart"></i> Top product
                </div>
                <img class="img-fluid border-0" src="https://dummyimage.com/600x400/55595c/fff" alt="Card image cap">
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="product.html" title="View Product">Product title</a></h4>
                    <div class="row">
                        <div class="col">
                            <p class="btn btn-danger btn-block">99.00 $</p>
                        </div>
                        <div class="col">
                            <a href="product.html" class="btn btn-success btn-block">View</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Last products
                </div>
                <div class="card-body">
                    <div class="row">
                        <c:forEach var="i" items="${latestProduct}" varStatus="status">
                            <c:if test="${status.index < 4}">
                                <div class="col-sm">
                                    <div class="card">
                                        <div>
                                        <c:if test="${i.images.size() > 0}">
                                            <img  class="card-img-top" src="<c:url value="/templates/images/${i.images[0].imageLink}"/>" alt="Card image cap">
                                        </c:if>
                                        <c:if test="${i.images.size() == 0}">
                                            <img  class="card-img-top" src="<c:url value="/templates/images/no-image.png"/>" alt="Card image cap">
                                        </c:if>
                                        </div>
                                        <div class="card-body">
                                            <h4 class="card-title"><a href="/product/${i.id}" title="View Product">${i.name}</a></h4>
                                            <p class="card-text">${i.description}</p>
                                            <div class="row">
                                                <div class="col">
                                                    <p class="btn btn-danger btn-block">${i.price}VNĐ</p>
                                                </div>
                                                <div class="col">
                                                    <a href="/product/${i.id}" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container mt-3 mb-4">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-trophy"></i> Best products
                </div>
                <div class="card-body">
                    <div class="row">
                        <c:forEach var="i" items="${bestProduct}" varStatus="status">
                            <c:if test="${status.index < 4}">
                                <div class="col-sm">
                                    <div class="card">
                                        <div >
                                        <c:if test="${i.images.size() > 0}">
                                            <img class="card-img-top" src="<c:url value="/templates/images/${i.images[0].imageLink}"/>" alt="Card image cap">
                                        </c:if>
                                        <c:if test="${i.images.size() == 0}">
                                            <img  class="card-img-top" src="<c:url value="/templates/images/no-image.png"/>" alt="Card image cap">
                                        </c:if>
                                        </div>
                                        <div class="card-body">
                                            <h4 class="card-title"><a href="/product/${i.id}" title="View Product">${i.name}</a></h4>
                                            <p class="card-text">${i.description}</p>
                                            <div class="row">
                                                <div class="col">
                                                    <p class="btn btn-danger btn-block">${i.price}VNĐ</p>
                                                </div>
                                                <div class="col">
                                                    <a href="/product/${i.id}" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>