<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đơn hàng</title>
    <!-- ======= Styles ====== -->
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
  <link rel="stylesheet" href="assets-admin/css/style_product_order.css">
</head>

<body>
    <!-- =============== Navigation ================ -->
    <div class="container">
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
				<h2 style="text-align: center;margin-top: 50px;font-size: 40px;">Chi tiết đơn hàng</h2>
				 	
			
			</div>
			
			
			<!-- List product category -->
			 <div class="details">
                <div class="recentOrders" style="display: block;"	>
                    <div class="cardHeader">
                        <h2>Danh sách các sản phẩm trong đơn hàng</h2>

                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên sản phẩm</td>       
                                <td>Số lượng đặt</td>
                                <td>Giá sản phẩm</td>
                            </tr>
                        </thead>

                        <tbody>
 
							<c:forEach var="item" items="${order_details}">
							  <tr>
                                <td>${item.product.nameProduct}</td>
								<td>${item.number}</td>
								
								
								<td>
									<fmt:setLocale value = "vi_VN"/>
	                    			<fmt:formatNumber value = "${item.price}" type = "currency"/>
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