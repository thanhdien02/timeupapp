<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
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
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Contact</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <span class="icon-check_circle display-3 text-success"></span>
            <h2 class="display-3 text-black">Cảm ơn bạn!</h2>
            <p class="lead mb-5">Đơn hàng của bạn đã được đặt thành công.</p>
            <p><a href="HomeServlet" class="btn btn-sm btn-primary">Quay lại tiếp tục mua sắm</a></p>
          </div>
        </div>
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