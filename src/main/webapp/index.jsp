<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

  <title>Timups</title>


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

</head>

<body>

  <div class="hero_area">
    <div class="hero_social">
      <a href="">
        <i class="fa fa-facebook" aria-hidden="true"></i>
      </a>
      <a href="">
        <i class="fa fa-twitter" aria-hidden="true"></i>
      </a>
      <a href="">
        <i class="fa fa-linkedin" aria-hidden="true"></i>
      </a>
      <a href="">
        <i class="fa fa-instagram" aria-hidden="true"></i>
      </a>
    </div>
    <!-- header section strats -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <!-- Header -->
    <jsp:include page="header.jsp" />  
    <!-- end header section -->
    <!-- slider section -->
    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container-fluid ">
              <div class="row">
                <div class="col-md-6">
                  <div class="detail-box">
                    <h1>
                     Ch??o m???ng ?????n v???i Timeup
                    </h1>
                    <p>
                     ????y l?? trang b??n ?????ng h??? th??ng minh d??nh cho ng?????i l???n v?? tr??? em.
                    </p>
                    <div class="btn-box">
                      <a href="" class="btn1">
                        Li??n h??? v???i ch??ng t??i
                      </a>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container-fluid ">
              <div class="row">
                <div class="col-md-6">
                  <div class="detail-box">
                    <h1>
                      Ch??o m???ng ?????n v???i Timeup
                    </h1>
                    <p>
                      ????y l?? trang b??n ?????ng h??? th??ng minh d??nh cho ng?????i l???n v?? tr??? em.
                    </p>
                    <div class="btn-box">
                      <a href="" class="btn1">
                        Li??n h??? v???i ch??ng t??i
                      </a>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container-fluid ">
              <div class="row">
                <div class="col-md-6">
                  <div class="detail-box">
                    <h1>
                      Ch??o m???ng ?????n v???i Timeup
                    </h1>
                    <p>
                      ????y l?? trang b??n ?????ng h??? th??ng minh d??nh cho ng?????i l???n v?? tr??? em.
                    </p>
                    <div class="btn-box">
                      <a href="" class="btn1">
                        Li??n h??? v???i ch??ng t??i
                      </a>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <ol class="carousel-indicators">
          <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
          <li data-target="#customCarousel1" data-slide-to="1"></li>
          <li data-target="#customCarousel1" data-slide-to="2"></li>
        </ol>
      </div>

    </section>
    <!-- end slider section -->
  </div>

  <!-- shop section -->

  <section class="shop_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
         	S???n ph???m ???????c xem g???n ????y
        </h2>
      </div>
      <div class="row">

        

        
           <c:forEach var="item" items="${products}">
       
			<div class="col-sm-6 col-xl-3">
	          <div class="box">
	            <a href="./ProductServlet?id=${item.productId}">
	              <div class="img-box">
	                <img src="${item.products_image[0].image_path}" alt="">
	              </div>
	              <div class="detail-box">
	                <h6>
	                  ${item.nameProduct}
	                </h6>
	                <h6>
	                  Price:
	                  <span>
	                    <fmt:setLocale value = "vi_VN"/>
	                    <fmt:formatNumber value = "${item.price }" type = "currency"/>
	                  </span>
	                </h6>
	              </div>
	              <div class="new">
	                <span>
	                  New
	                </span>
	              </div>
	            </a>
	          </div>
	        </div>		 
		</c:forEach>
        
        
        
      </div>
      
      
    </div>
  </section>

  <!-- end shop section -->

  <!-- about section -->

  <section class="about_section layout_padding">
    <div class="container  ">
      <div class="row">
        <div class="col-md-6 col-lg-5 ">
          <div class="img-box">
            <img src="images/about-img.png" alt="">
          </div>
        </div>
        <div class="col-md-6 col-lg-7">
          <div class="detail-box">
            <div class="heading_container">
              <h2>
                V??? ch??ng t??i
              </h2>
            </div>
            <p>
              Nh??m sinh vi??n c???a Tr?????ng ?????i H???c S?? Ph???m K??? Thu???t TP.HCM
            </p>
            <a href="">
              T??m hi???u th??m
            </a>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end about section -->

  <!-- feature section -->

  <section class="feature_section layout_padding">
    <div class="container">
      <div class="heading_container">
        <h2>
          C??c t??nh n??ng c???a ?????ng h??? c???a ch??ng t??i
        </h2>
        <p>
          
        </p>
      </div>
      <div class="row">
        <div class="col-sm-6 col-lg-3">
          <div class="box">
            <div class="img-box">
              <img src="images/f1.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                Theo gi???i s???c kh???e
              </h5>
              <p>
                
              </p>
              <a href="">
                <span>
                  Read More
                </span>
                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-3">
          <div class="box">
            <div class="img-box">
              <img src="images/f2.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                B??o th???c v?? th??ng b??o
              </h5>
              <p>
               
              </p>
              <a href="">
                <span>
                  ?????c th??m
                </span>
                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-3">
          <div class="box">
            <div class="img-box">
              <img src="images/f3.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                Messages
              </h5>
              <p>
                
              </p>
              <a href="">
                <span>
                  ?????c th??m
                </span>
                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-3">
          <div class="box">
            <div class="img-box">
              <img src="images/f4.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                Bluetooth
              </h5>
              <p>
                
              </p>
              <a href="">
                <span>
                 ?????c th??m
                </span>
                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="btn-box">
        <a href="">
          Xem th??m
        </a>
      </div>
    </div>
  </section>

  <!-- end feature section -->

  <!-- contact section -->

  <section class="contact_section">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <div class="form_container">
            <div class="heading_container">
              <h2>
                Li??n h??? v???i ch??ng t??i
              </h2>
            </div>
            <form action="">
              <div>
                <input type="text" placeholder="Full Name " />
              </div>
              <div>
                <input type="email" placeholder="Email" />
              </div>
              <div>
                <input type="text" placeholder="Phone number" />
              </div>
              <div>
                <input type="text" class="message-box" placeholder="Message" />
              </div>
              <div class="d-flex ">
                <button>
                  G???I
                </button>
              </div>
            </form>
          </div>
        </div>
        <div class="col-md-6">
          <div class="img-box">
            <img src="images/contact-img.jpg" alt="">
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end contact section -->

  <!-- client section -->
  <section class="client_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Nh???ng ????nh gi??
        </h2>
      </div>
      <div class="carousel-wrap ">
        <div class="owl-carousel client_owl-carousel">
          <div class="item">
            <div class="box">
              <div class="img-box">
                <img src="images/c1.jpg" alt="">
              </div>
              <div class="detail-box">
                <div class="client_info">
                  <div class="client_name">
                    <h5>
                     Nguy???n V??n An
                    </h5>
                    <h6>
                      Kh??ch h??ng
                    </h6>
                  </div>
                  <i class="fa fa-quote-left" aria-hidden="true"></i>
                </div>
                <p>
                  Nh??n vi??n th??n thi???n, h??? tr??? nhi???t t??nh. N???u trong l??c ng???i ?????i ho??n th??nh th??? t???c mua ho???c xem. C?? th??m khay k???o ho???c ly n?????c th?? tuy???t v???i h??n n???a
                </p>
              </div>
            </div>
          </div>
          <div class="item">
            <div class="box">
              <div class="img-box">
                <img src="images/c2.jpg" alt="">
              </div>
              <div class="detail-box">
                <div class="client_info">
                  <div class="client_name">
                    <h5>
                      Nguy???n Th??? M??? Duy??n
                    </h5>
                    <h6>
                      Kh??ch h??ng
                    </h6>
                  </div>
                  <i class="fa fa-quote-left" aria-hidden="true"></i>
                </div>
                <p>
                  Nh??n vi??n th??n thi???n, h??? tr??? nhi???t t??nh. N???u trong l??c ng???i ?????i ho??n th??nh th??? t???c mua ho???c xem. C?? th??m khay k???o ho???c ly n?????c th?? tuy???t v???i h??n n???a
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- end client section -->


  <!-- footer section -->
	<jsp:include page="footer.jsp" /> 
  <!-- footer section -->

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- popper js -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- owl slider -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap"></script>
  <!-- End Google Map -->

</body>

</html>