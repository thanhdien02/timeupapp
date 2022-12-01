<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Đặt hàng</title>
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
     <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    
  </head>
  <body>
  
  <div class="site-wrap">
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- Header -->
    <jsp:include page="header.jsp" /> 

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="HomeServlet">Home</a> <span class="mx-2 mb-0">/</span> <a href="CartServlet">Cart</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Checkout</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12">
            <div class="border p-4 rounded" role="alert">
              Returning customer? <a href="#">Click here</a> to login
            </div>
          </div>
        </div>
        
        
        
        <form action="CheckoutServlet" method="post">
	        <div class="row">
	          <div class="col-md-6 mb-5 mb-md-0">
	            <h2 class="h3 mb-3 text-black">Chi tiết đơn hàng.</h2>
	            <div class="p-3 p-lg-5 border">
	
	              <div class="form-group row">
	                <div class="col-md-12">
	                  <label for="c_address" class="text-black">Họ và Tên <span class="text-danger">*</span></label>
	                  <input type="text" class="form-control" id="c_address" value="${user.fullName }" name="fullname" placeholder="Street address">
	                </div>
	                
	              </div>
	
	              
	
	              <div class="form-group row">
	                <div class="col-md-12">
	                  <label for="c_address" class="text-black">Địa chỉ <span class="text-danger">*</span></label>
	                  <input type="text" class="form-control" id="c_address" value="${user.address[0].number_Home }" name="number_addess" placeholder="Số nhà" required>
	                </div>
	              </div>
	
	              
	
	              <div class="form-group row">
	              
	                <div class="col-md-6">
	                  <label for="c_state_country" class="text-black">Thành phố <span class="text-danger">*</span></label>
	                  <input type="text" class="form-control" id="c_state_country" value="${user.address[0].ciTy }" name="city" placeholder="Thành phố" required>
	                </div>
	                <div class="col-md-6">
	                  <label for="c_postal_zip" class="text-black">Quận <span class="text-danger">*</span></label>
	                  <input type="text" class="form-control" id="c_postal_zip" value="${user.address[0].dicstrict }" name="dicstrict" placeholder="Quận" required>
	                </div>
	              </div>
	
	              <div class="form-group row mb-5">
	                <div class="col-md-6">
	                  <label for="c_email_address" class="text-black">Phường <span class="text-danger">*</span></label>
	                  <input type="text" class="form-control" id="c_email_address" value="${user.address[0].ward }" name="ward" placeholder="Phường" required>
	                </div>
	                <div class="col-md-6">
	                  <label for="c_phone" class="text-black">Số điện thoại <span class="text-danger">*</span></label>
	                  <input type="text" class="form-control" id="c_phone" value="${user.numberPhone }" name="phone" placeholder="Số điện thoại" required>
	                </div>
	              </div>
	
	              <div class="form-group">
	                <label for="c_create_account" class="text-black" data-toggle="collapse" href="#create_an_account" role="button" aria-expanded="false" aria-controls="create_an_account"><input type="checkbox" value="1" id="c_create_account"> Create an account?</label>
	                <div class="collapse" id="create_an_account">
	                  <div class="py-2">
	                    <p class="mb-3">Create an account by entering the information below. If you are a returning customer please login at the top of the page.</p>
	                    <div class="form-group">
	                      <label for="c_account_password" class="text-black">Account Password</label>
	                      <input type="email" class="form-control" id="c_account_password" name="c_account_password" placeholder="">
	                    </div>
	                  </div>
	                </div>
	              </div>

	              <div class="form-group">
	                <label for="c_order_notes" class="text-black">Ghi chú thêm</label>
	                <textarea name="order_note" id="c_order_notes" cols="30" rows="5" class="form-control" placeholder="Viết lưu ý vào đây...."></textarea>
	              </div>
	
	            </div>
	          </div>
	          <div class="col-md-6">
	
	
	            
	            <div class="row mb-5">
	              <div class="col-md-12">
	                <h2 class="h3 mb-3 text-black">Đơn hàng của bạn</h2>
	                <div class="p-3 p-lg-5 border">
	                  <table class="table site-block-order-table mb-5">
	                    <thead>
	                      <th>Sản phẩm</th>
	                      <th>Tổng</th>
	                    </thead>
	                    <tbody>
	                     
	                      
	                      <c:forEach var="item" items="${products}">
		                      <tr>
		                        <td>${item.nameProduct } <strong class="mx-2">x</strong>   1</td>
		                        <td>
		                        <fmt:setLocale value = "vi_VN"/>
	                    		<fmt:formatNumber value = "${item.price }" type = "currency"/>
		                        
		                          Số lượng mua: ${item.quantity }</td>
		                      </tr>
	                      </c:forEach>
	                      <tr>
	                        <td class="text-black font-weight-bold"><strong>Tổng giỏ hàng</strong></td>
	                        <td class="text-black">
	                        
	                        <fmt:setLocale value = "vi_VN"/>
	                    	<fmt:formatNumber value = "${sumcart }" type = "currency"/>
	                        <input type="hidden" name="priceSum" value="${sumcart }">
	                        </td>
	                      </tr>
	                      
	                    </tbody>
	                  </table>
	
	                  <div class="border p-3 mb-3">
	                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsebank" role="button" aria-expanded="false" aria-controls="collapsebank">Direct Bank Transfer</a></h3>
	
	                    <div class="collapse" id="collapsebank">
	                      <div class="py-2">
	                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
	                      </div>
	                    </div>
	                  </div>
	
	                  
	
	                  <div class="form-group">
	                  	<input type="hidden" name="action" value="checkout">
	                    <button class="btn btn-primary btn-lg py-3 btn-block" type="submit">Đặt hàng</button>
	                  </div>
	
	                </div>
	              </div>
	            </div>
	
	          </div>
	        </div>
        </form>
        
        <!-- </form> -->
      </div>
    </div>

    <jsp:include page="footer.jsp" />
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>
    
  </body>
</html>