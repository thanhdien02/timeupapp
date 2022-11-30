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
				<h2 style="text-align: center;margin-top: 50px;font-size: 40px;">Danh sách đơn hàng</h2>
				 	
			
			</div>
			
			
			<!-- List product category -->
			 <div class="details">
                <div class="recentOrders" style="display: block;"	>
                    <div class="cardHeader">
                        <h2>Các đơn hàng gần đây</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên người đặt</td>       
                                <td>Ngày đặt hàng</td>
                                <td>Tổng đơn hàng</td>
                                <td>Chi tiết đơn hàng</td>
                            </tr>
                        </thead>

                        <tbody>
 
							<c:forEach var="item" items="${orders}">
							  <tr>
                                <td>${item.user.fullName}</td>
								<td>${item.dateShip}</td>
								
								
								<td>
									<fmt:setLocale value = "vi_VN"/>
	                    			<fmt:formatNumber value = "${item.priceSum}" type = "currency"/>
								</td>
								<td>
									<form action="OrderdetailServlet" method="post">
										
										<input type="hidden" name="action" value="admin">
										<input type="hidden" name="idorder" value="${item.orderId }">
										<input type="submit" style="border: none;width: 120px;height: 35px;" value="Chi tiết" class="status delivered">
									</form>
								
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