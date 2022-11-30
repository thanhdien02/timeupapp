<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.NumberFormat"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Đơn hàng của bạn</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="./assets-cart/fonts/icomoon/style.css">

    <link rel="stylesheet" href="./assets-cart/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets-cart/css/magnific-popup.css">
    <link rel="stylesheet" href="./assets-cart/css/jquery-ui.css">
    <link rel="stylesheet" href="./assets-cart/css/owl.carousel.min.css">
    <link rel="stylesheet" href="./assets-cart/css/owl.theme.default.min.css">


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
          <div class="col-md-12 mb-0"><a href="HomeServlet">Trang chủ</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Đơn hàng/Chi tiết đơn hàng</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
        
        
          
          
          
            <div class="site-blocks-table" style="width: 100%;">
              <table class="table table-bordered">
              <!-- Titile -->
                <thead>
                  <tr>
                    <th class="product-thumbnail" style="width: 500px;">Tên sản phẩm</th>
                    <th class="product-name">Số lượng đặt</th>
                    <th class="product-price">Giá sản phẩm</th>
                  </tr>
                </thead>
                <tbody>
                
                <!-- List cart -->

		        <c:forEach var="item" items="${order_details}">
		       	 <tr>
                    <td class="product-thumbnail">
						${item.product.nameProduct}
                    </td>
                    <td class="product-name">
                    
                      <h2 class="h5 text-black">${item.number}</h2>
                      
                    </td>
                    <td>
                    
                    <fmt:setLocale value = "vi_VN"/>
                    <fmt:formatNumber value = "${item.price }" type = "currency"/>
                    </td>
	                  

                  </tr>
				</c:forEach>

 
                </tbody>
              </table>
              
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