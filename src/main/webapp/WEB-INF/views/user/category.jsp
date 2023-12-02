<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="temp" value="0"/>
<body>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE CATEGORY</h1>
        <p class="lead text-muted mb-0">Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte...</p>
    </div>
</section>
<div class="container">

    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                    <li class="list-group-item"><a href="/category">Tất cả</a></li>
                    <c:forEach var="i" items="${list_category}">

                        <li class="list-group-item"><a href="/category/${i.id}">${i.name} (${listCountProduct.get(temp)} sản phẩm)</a></li>

                        <c:set var="temp" value="${temp + 1}"/>

                    </c:forEach>
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Search for brand</div>
                <ul class="list-group category_block">
                    <li class="list-group-item"><a href="/category/${sessionScope.category_id}">Tất cả</a></li>
                    <c:forEach var="i" items="${list_brand}">
                        <li class="list-group-item"><a href="/category/brand/${i.id}">${i.name}</a></li>
                    </c:forEach>
                </ul>
            </div>

<%--            <div class="card bg-light mb-3">--%>
<%--                <div class="card-header bg-success text-white text-uppercase">Last product</div>--%>
<%--                <div class="card-body">--%>
<%--                    <img class="img-fluid" src="https://dummyimage.com/600x400/55595c/fff" />--%>
<%--                    <h5 class="card-title">Product title</h5>--%>
<%--                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
<%--                    <p class="bloc_left_price">99.00 $</p>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <div class="col">
            <div class="row" id="content">
                <c:forEach var="i" items="${list_product_category}">
                    <div class="product col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <c:if test="${i.images.size() > 0}">
                                <img class="card-img-top" src="<c:url value="/templates/images/${i.images[0].imageLink}"/>" alt="Card image cap">
                            </c:if>
                            <c:if test="${i.images.size() == 0}">
                                <img class="card-img-top" src="<c:url value="/templates/images/no-image.png"/>" alt="Card image cap">
                            </c:if>
                            <div class="card-body">
                                <h4 class="card-title"><a href="/product/${i.id}" title="View Product">${i.name} </a></h4>
                                <pre class="card-text">${i.description}</pre>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${i.price} $</p>
                                    </div>
                                    <div class="col">
                                        <a href="/product/${i.id}" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>


                <div class="col-12">
                    <nav aria-label="...">
                        <div class="data-container" id="data-container" style="display: flex;">
                            <button class="btn_page left page-item page-link" onclick="previous()">Previous</button>
                            <ul class="pagination" id="pagination">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item active">
                                    <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#">Next</a>
                                </li>
                            </ul>
                            <button class="btn_page right page-item page-link"  >Next</button>
                        </div>

                    </nav>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
   var listProduct = document.querySelectorAll(".product");
   var btn_previous = document.querySelector(".btn_page.left");
   var btn_next = document.querySelector(".btn_page.right");

   let thisPost=1;
   let limitPost=6;

    function previous() {
        if (thisPost > 1) {
            thisPost--;
            loadPost();
        }
    }
    function next() {
        if (thisPost < Math.ceil(listProduct.length / limitPost)) {
            thisPost++;
            loadPost();
        }
    }

    btn_next.addEventListener("click",()=>{
      if(thisPost<Math.ceil(listProduct.length/limitPost)){
         thisPost++;
         loadPost();
      }
    });
   function loadPost(){
     let begin = (thisPost-1)*limitPost;
     let end = thisPost*limitPost-1;
     listProduct.forEach((item,index)=>{
       if(index>=begin && index<=end){
         item.style.display="block";
       }else{
         item.style.display="none";
       }
     })
       listPost();
   }
   loadPost();

   function listPost() {
       let count = Math.ceil(listProduct.length / limitPost);
       document.querySelector(".pagination").innerHTML = "";

       for (i = 1; i <= count; i++) {
           let newPost = document.createElement("li");
           newPost.classList.add("page-item")
           newPost.classList.add("page-link")
           newPost.innerText = i;
           if (i === thisPost) {
               newPost.classList.add("active1");
           }
           newPost.setAttribute("onclick", "changePost(" + i + ")");
           document.querySelector(".pagination").appendChild(newPost);
       }

   }
   function changePost(post) {
       thisPost = post;
       loadPost();
   }

</script>
</body>
