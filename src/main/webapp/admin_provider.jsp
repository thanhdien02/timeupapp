<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhà cung cấp</title>
    <!-- ======= Styles ====== -->
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
  <link rel="stylesheet" href="./assets-admin/css/style_admin_provider.css">
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
				<h2>Thêm nhà cung cấp mới</h2>
				 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<c:if test="${kiemtra == 'datontai'}">
		        	<p style="color: red;margin-top: -35px;margin-bottom: 20px;margin-left: -255px;">Nhà cung cấp đã được lưu trước đó</p>
		   		 </c:if>
		   		 <form action="ProviderServlet" method="post">
					<div class="container-input">
						<div class="item-input">
							<label>Tên nhà cung cấp</label>
							<input type="text" required placeholder="Tên nhà cung cấp" class="name_cate" name="nameprovider">
						</div>
						<div class="item-input">
							<label>Số điện thoại</label>
							<input type="text" required placeholder="Số điện thoại"  class="name_cate" name="numberphone">
						</div>
						
						
						
					</div>
					
					<div class="submit">
						<input type="hidden" value="addprovider" name="action">
						<input type="submit" value="Thêm nhà cung cấp" class="submit_cate">
					
					</div>
				</form>
			
			</div>
			
			
			<!-- List product category -->
			 <div class="details">
                <div class="recentOrders" style="display: block;">
                    <div class="cardHeader">
                        <h2>Nhà cung cấp gần đây</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên</td>
                                <td>Số điện thoại</td>
                                <td>Xóa</td>
                                <td>Cập nhật</td>
                            </tr>
                        </thead>

                        <tbody>
                       
                            
							<c:forEach var="item" items="${providers}">
							  <tr>
                                <td>${item.nameProvider}</td>
                                <td>${item.numberPhone}</td>
                                <td>
                                	<form action="ProviderServlet" method="post">
										
										<input type="hidden" name="action" value="delete">
										<input type="hidden" name="idprovider" value="${item.providerId }">
										<input type="submit" value="Xóa" class="status delivered" style="background: red">
									</form>
                                </td>

								<td>
									<form action="ProviderServlet" method="post">
										
										<input type="hidden" name="action" value="update">
										
										<input type="submit" value="Chỉnh sửa" class="status delivered">
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