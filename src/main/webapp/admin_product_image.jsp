<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lí sản phẩm</title>
    <!-- ======= Styles ====== -->
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
  <link rel="stylesheet" href="./assets-admin/css/style_product_addnew.css">
</head>

<body>
    <!-- =============== Navigation ================ -->
    <div class="container">
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Header -->
    <jsp:include page="admin_menu.jsp" /> 
        
        <div class="main">
            <div class="topbar">
                <div class="toggle">
                    <ion-icon name="menu-outline"></ion-icon>
                </div>

                <div class="search">
                    <label>
                        <input type="text" placeholder="Tìm kiếm">
                        <ion-icon name="search-outline"></ion-icon>
                    </label>
                </div>

                <div class="user">
                    <img src="./assets-admin/imgs/customer01.jpg" alt="">
                </div>
            </div>
			
				
			<div class="addproduct_catedory"> <!-- đặt nó ở trong form rồi thêm loại sản phẩm cho nó mà tôi -->
				<h2>Thêm ảnh cho sản phẩm</h2>
				 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<c:if test="${kiemtra == 'datontai'}">
		        	<p style="color: red;margin-top: -35px;margin-bottom: 20px;margin-left: -255px;">Loại sản phẩm này đã có trong kho</p>
		   		 </c:if>
		   		 <form action="ProductImage" method="post">
					<div class="container-input">
						<div class="item-input">
							<label>Tên sản phẩm</label>
							<input type="text" value="${productadd.nameProduct}"  placeholder="Tên sản phẩm" class="name_cate" name="nameproduct">
						</div>
						
						<div class="item-input">
							<label>Giá sản phẩm</label>
							<input type="number" value="${productadd.price}"  placeholder="Giá" class="name_cate" name="priceproduct">
						</div>
						
						<div class="item-input">
							<label>Địa chỉ của ảnh</label>
							<input type="text" required placeholder="Địa chỉ của ảnh" class="name_cate" name="path_image">
						</div>
						
						
					</div>
					
					<div class="submit">
						<input type="hidden" value="" name="product">
						<input type="hidden" value="addimage" name="action">
						<input type="submit" value="Thêm ảnh" class="submit_cate">
					
					</div>
					
					
				</form>
				 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<h2> Ten là ${productadd.nameProduct} </h2>

			</div>
			
			
			<!-- List product category -->
			 <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Ảnh được thêm vào</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên loại</td>
                                <td>Giá</td>
                                <td>Số lượng còn</td>
                                <td>Ảnh</td>
                            </tr>
                        </thead>

                        <tbody>
                       
                            
							<c:forEach var="item" items="${product_images}">
							  <tr>
                                <td>${item.product.nameProduct}</td>
                                <td>${item.product.price}</td>
                                <td>${item.product.number_remain}</td>

								<td>
								
									<img alt="" src="${item.image_path}" style="width: 100px;">

								</td>
								
                                
                            </tr>
							</c:forEach>
                      
                        </tbody>
                    </table>
                </div>
        </div>
        
    </div>

    <!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>