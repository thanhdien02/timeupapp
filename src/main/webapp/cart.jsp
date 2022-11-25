<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Giỏ hàng</title>
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
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- Header -->
    <jsp:include page="header.jsp" />

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Cart</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
        
        
          <form class="col-md-12" method="post" action="CartServlet">
          
          
            <div class="site-blocks-table">
              <table class="table table-bordered">
              
              <!-- Titile -->
                <thead>
                  <tr>
                    <th class="product-thumbnail">Ảnh</th>
                    <th class="product-name">Sản phẩm</th>
                    <th class="product-price">Giá</th>
                    <th class="product-quantity">Số lượng</th>
                    <th class="product-total">Tổng</th>
                    <th class="product-remove">Xóa</th>
                  </tr>
                </thead>
                <tbody>
                
                <!-- List cart -->

		        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		        
		        <c:forEach var="item" items="${products}">
		       	 <tr>
                    <td class="product-thumbnail">
                      <img src="${item.products_image[0].image_path }" alt="Image" class="img-fluid">
                    </td>
                    <td class="product-name">
                    
                      <h2 class="h5 text-black">${item.nameProduct }</h2>
                      
                    </td>
                    <td>${item.price }</td>
                    <td>
                      <div class="input-group mb-3" style="max-width: 120px;">
                        <div class="input-group-prepend">
                          <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
                        </div>
                        <input type="text" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                        <div class="input-group-append">
                          <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
                        </div>
                      </div>

                    </td>
                    <td>$49.00</td>
                    <td>
					<input type="hidden" value="${item.productId }" name="iddelete"> 
					<input type="hidden" value="detelecartproduct" name="action">
					<input class="btn btn-primary btn-sm" type="submit" value="X" >
                    </td>
                  </tr>
				</c:forEach>

 
                </tbody>
              </table>
              
            </div>
          </form>
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-6 mb-3 mb-md-0">
                <button class="btn btn-primary btn-sm btn-block">Cập nhật giỏ hàng</button>
              </div>
	              <div class="col-md-6">
		              <a href="./HomeServlet">
			              	<button type="submit" class="btn btn-outline-primary btn-sm btn-block">Tiếp tục mua sắm</button>
		              </a>
	              </div>
              
            </div>
            <div class="row">
              <div class="col-md-12">
                <label class="text-black h4" for="coupon">Coupon</label>
                <p>Enter your coupon code if you have one.</p>
              </div>
              <div class="col-md-8 mb-3 mb-md-0">
                <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
              </div>
              <div class="col-md-4">
                <button class="btn btn-primary btn-sm">Apply Coupon</button>
              </div>
            </div>
          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 text-right border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Tổng giỏ hàng</h3>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-md-6">
                    <span class="text-black">Phụ phí</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">$230.00</strong>
                  </div>
                </div>
                <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Tổng</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">$230.00</strong>
                  </div>
                </div>

                <div class="row">
                
                  <div class="col-md-12">
                    <button class="btn btn-primary btn-lg py-3 btn-block" onclick="window.location='checkout.jsp'">Tiến hành thanh toán</button>
                  </div>
                </div>
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