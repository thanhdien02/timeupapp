<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Chi tiết sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">

    <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
     <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>

<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- Header -->
    <jsp:include page="header.jsp" />  
    <!-- Close Header -->

    <!-- Modal -->


    <!-- Open Content -->
    <section class="bg-light">
        <div class="container pb-5">
        
            <div class="row">
            
            
        
            
                <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                        <img class="card-img img-fluid" src="${product.products_image[0].image_path}" alt="Card image cap" id="product-detail">
                    </div>
                    
                    
                    <div class="row">
                        <!--Start Controls-->
                        <div class="col-1 align-self-center">
                            <a href="#multi-item-example" role="button" data-bs-slide="prev">
                                <i class="text-dark fas fa-chevron-left"></i>
                                <span class="sr-only">Previous</span>
                            </a>
                        </div>
                        <!--End Controls-->
                        <!--Start Carousel Wrapper-->
                        <div id="multi-item-example" class="col-10 carousel slide carousel-multi-item" data-bs-ride="carousel">
                            <!--Start Slides-->
                            <div class="carousel-inner product-links-wap" role="listbox">

                                <!--First slide-->
                                <div class="carousel-item active">
                                    <div class="row">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[0].image_path}" alt="Product Image 1">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[1].image_path}" alt="Product Image 2">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[2].image_path}" alt="Product Image 3">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!--/.First slide-->

                                <!--Second slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[0].image_path}" alt="Product Image 4">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[1].image_path}" alt="Product Image 5">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[2].image_path}" alt="Product Image 6">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!--/.Second slide-->

                                <!--Third slide-->
                                <div class="carousel-item">
                                    <div class="row">
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[0].image_path}" alt="Product Image 4">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[1].image_path}" alt="Product Image 5">
                                            </a>
                                        </div>
                                        <div class="col-4">
                                            <a href="#">
                                                <img class="card-img img-fluid" src="${product.products_image[2].image_path}" alt="Product Image 6">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!--/.Third slide-->
                            </div>
                            <!--End Slides-->
                        </div>
                        <!--End Carousel Wrapper-->
                        <!--Start Controls-->
                        <div class="col-1 align-self-center">
                            <a href="#multi-item-example" role="button" data-bs-slide="next">
                                <i class="text-dark fas fa-chevron-right"></i>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <!--End Controls-->
                    </div>
                </div>
                <!-- col end -->
                
                
                
                
                
   
                
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="h2">${product.nameProduct }</h1>
                            
                            <p class="h3 py-2">
                            <fmt:setLocale value = "vi_VN"/>
                            <fmt:formatNumber value = "${product.price }" type = "currency"/>
                            
                            </p>
                            <p class="py-2">
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-warning"></i>
                                <i class="fa fa-star text-secondary"></i>
                                <span class="list-inline-item text-dark">Rating 4.8 | 36 Comments</span>
                            </p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Hãng:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>${product.pd_category.nameCategory }</strong></p>
                                </li>
                            </ul>

                            <h6>Mô tả:</h6>
                            <p>${product.pd_specification.desciption }</p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Màu :</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>${product.pd_specification.color }</strong></p>
                                </li>
                            </ul>

                            <h6>Thông số:</h6>
                            <ul class="list-unstyled pb-3">
                                <li></li>
                                <li>Thời gian sử dụng: ${product.pd_specification.use_time } tiếng</li>
                                <li>Nguồn gốc: ${product.pd_specification.origin }</li>
                                <li>Kích thước màn hình: ${product.pd_specification.sizeGreen }</li>
                                <li>Trọng lượng: ${product.pd_specification.weight }</li>
                            </ul>
							<h6>Dành cho: ${item.cateAge }</h6>
                           
                                <input type="hidden" name="product-title" value="Activewear">
                                
                            <form action="CartServlet" method="post">
                            
                                <div class="row">
                                    <div class="col-auto">
                                        <ul class="list-inline pb-3">
                                            <li class="list-inline-item text-right">
                                                Số lượng
                                                <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                            </li>
                                            
                                            <li class="list-inline-item">
                                            
                                            
                                           <input type="number" name="quantity" value="1" >
                                            
                                        </ul>
                                    </div>
                                </div>
                            
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                    	<input type="hidden" name="action" value="addproduct">
                                    	<input type="hidden" name="id" value="${product.productId }">
                                        <input type="submit" class="btn btn-success btn-lg" name="submit" value="Thêm vào giỏ hàng">
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
                
                
                
                
                
            </div>
        </div>
    </section>
    <!-- Close Content -->










    <!-- Start Article -->
    <section class="py-5">
        <div class="container">
            <div class="row text-left p-2 pb-3">
                <h4>Sản phẩm liên quan</h4>
            </div>

            <!--Start Carousel Wrapper-->
            <div id="carousel-related-product">


				<c:forEach var="item" items="${products}">
	                <div class="p-2 pb-3">
	                    <div class="product-wap card rounded-0" style="height: 460px;">
	                        <div class="card rounded-0">
	                            <img class="card-img rounded-0 img-fluid" src="${item.products_image[0].image_path }">
	                            <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
	                                <ul class="list-unstyled">
	                                    <li><a class="btn btn-success text-white" href="./ProductServlet?id=${item.productId}"><i class="far fa-heart"></i></a></li>
	                                    <li><a class="btn btn-success text-white mt-2" href="./ProductServlet?id=${item.productId}"><i class="far fa-eye"></i></a></li>
	                                    <li><a class="btn btn-success text-white mt-2" href="./ProductServlet?id=${item.productId}"><i class="fas fa-cart-plus"></i></a></li>
	                                </ul>
	                            </div>
	                        </div>
	                        <div class="card-body">
	                            <a href="./ProductServlet?id=${item.productId}" class="h3 text-decoration-none">${item.nameProduct }</a>
	                            <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
	                                <li>M/L/X/XL</li>
	                                <li class="pt-2">
	                                    <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
	                                    <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
	                                    <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
	                                    <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
	                                    <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
	                                </li>
	                            </ul>
	                            
	                            <p class="text-center mb-0">
	                            
		                            <fmt:setLocale value = "vi_VN"/>
	                            	<fmt:formatNumber value = "${item.price }" type = "currency"/>
	                            
	                            </p>
	                        </div>
	                    </div>
	                </div>

				</c:forEach>
             

            </div>


        </div>
    </section>
    <!-- End Article -->


    <!-- Start Footer -->
   	<jsp:include page="footer.jsp" /> 
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    <!-- End Script -->

    <!-- Start Slider Script -->
    <script src="assets/js/slick.min.js"></script>
    <script>
        $('#carousel-related-product').slick({
            infinite: true,
            arrows: false,
            slidesToShow: 4,
            slidesToScroll: 3,
            dots: true,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                }
            ]
        });
    </script>
    <!-- End Slider Script -->

</body>

</html>