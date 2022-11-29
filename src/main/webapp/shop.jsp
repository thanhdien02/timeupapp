<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="./assets-cart/fonts/icomoon/style.css">

    <link rel="stylesheet" href="./assets-cart/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets-cart/css/magnific-popup.css">
    <link rel="stylesheet" href="./assets-cart/css/jquery-ui.css">
    <link rel="stylesheet" href="./assets-cart/css/owl.carousel.min.css">
    <link rel="stylesheet" href="./assets-cart/css/owl.theme.default.min.css">

    <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="./assets-cart/css/aos.css">

    <link rel="stylesheet" href="./assets-cart/css/style.css">
    
  </head>
  <body>
  
  <div class="site-wrap">
 


    <!-- Header -->
    <jsp:include page="header.jsp" />

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Trang chủ</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Sản phẩm</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-2">

            <div class="row">
              <div class="col-md-12 mb-5">
                <div class="float-md-left mb-4"><h2 class="text-black h5">Tất cả</h2></div>
                <div class="d-flex">
                  <div class="dropdown mr-1 ml-md-auto">
                    <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Gần đây
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                      <a class="dropdown-item" href="./Product?action=nguoilon">Người lớn</a>
                      <a class="dropdown-item" href="./Product?action=treem">Trẻ em</a>
                    </div>
                  </div>

                </div>
              </div>
            </div>
            <div class="row mb-5">

              
              <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
              
              
 			<c:forEach var="item" items="${products}">
              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up" style="height:480px ">
                <div class="block-4 text-center border"  style="height:470px ">
                  <figure class="block-4-image">
                    <a href="./ProductServlet?id=${item.productId}"><img src="${item.products_image[0].image_path}" alt="Image placeholder" class="img-fluid"></a>
                  </figure>
                  <div class="block-4-text p-4">
                    <h3><a href="./ProductServlet?id=${item.productId}">${item.nameProduct}</a></h3>
                    <p class="mb-0">Finding perfect products</p>
                    <p class="text-primary font-weight-bold">
                    
                    	<fmt:setLocale value = "vi_VN"/>
	                    <fmt:formatNumber value = "${item.price }" type = "currency"/>
                    
                    </p>
                  </div>
                </div>
              </div>
			</c:forEach>


	
            </div>
            <div class="row" data-aos="fade-up">
              <div class="col-md-12 text-center">
                <div class="site-block-27">
                  <ul>
                    <li><a href="#">&lt;</a></li>
                    <li class="active"><span>1</span></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&gt;</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-3 order-1 mb-5 mb-md-0">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Loại sản phẩm</h3>
              <ul class="list-unstyled mb-0">
              
              
                
                <c:forEach var="item" items="${product_categorys}">
              		<li class="mb-1"><a href="./Product?action=${item.nameCategory}" class="d-flex"><span>${item.nameCategory}</span> <span class="text-black ml-auto">(2,220)</span></a></li>
				</c:forEach>
                
                
              </ul>
            </div>

            <div class="border p-4 rounded mb-4">
              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Tìm theo giá</h3>
                <div id="slider-range" class="border-primary"></div>
                <input type="text" name="text" id="amount" class="form-control border-0 pl-0 bg-white" disabled="" />
              </div>

              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Size</h3>
                <label for="s_sm" class="d-flex">
                  <input type="checkbox" id="s_sm" class="mr-2 mt-1"> <span class="text-black">Small (2,319)</span>
                </label>
                <label for="s_md" class="d-flex">
                  <input type="checkbox" id="s_md" class="mr-2 mt-1"> <span class="text-black">Medium (1,282)</span>
                </label>
                <label for="s_lg" class="d-flex">
                  <input type="checkbox" id="s_lg" class="mr-2 mt-1"> <span class="text-black">Large (1,392)</span>
                </label>
              </div>

              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Color</h3>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-danger color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Red (2,429)</span>
                </a>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-success color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Green (2,298)</span>
                </a>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-info color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Blue (1,075)</span>
                </a>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-primary color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Purple (1,075)</span>
                </a>
              </div>

            </div>
          </div>
        </div>


        
      </div>
    </div>

	<jsp:include page="footer.jsp" />
	
  </div>

  <script src="./assets-cart/js/jquery-3.3.1.min.js"></script>
  <script src="./assets-cart/js/jquery-ui.js"></script>
  <script src="./assets-cart/js/popper.min.js"></script>
  <script src="./assets-cart/js/bootstrap.min.js"></script>
  <script src="./assets-cart/js/owl.carousel.min.js"></script>
  <script src="./assets-cart/js/jquery.magnific-popup.min.js"></script>
  <script src="./assets-cart/js/aos.js"></script>

  <script src="./assets-cart/js/main.js"></script>
    
  </body>
</html>