<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhập thêm sản phẩm</title>
    <!-- ======= Styles ====== -->
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
  <link rel="stylesheet" href="./assets-admin/css/style_product_import.css">
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
			
				
			<div class="addproduct_catedory" style="text-align: center;"> <!-- đặt nó ở trong form rồi thêm loại sản phẩm cho nó mà tôi -->
				<h2 style="font-size: 45px;margin: 60px 0;font-weight: 600;color: var(--blue);">Nhập thêm hàng vào kho</h2>
				 <h2 style="margin-bottom: 24px;">Tên sản phẩm: ${product.nameProduct }</h2>
				<form action="ProductCategory" method="post">
				
					<input type="hidden" name="idproduct" value="${product.productId } ">
					<input type="hidden" name="action" value="updatenumberproduct">
					<input type="text" required placeholder="Số lượng nhập vào" class="name_cate" name="namecategory" style="height: 40px;border-radius: 40px;padding: 5px 20px;padding-left: 20px;padding-left: 35px;font-size: 18px;outline: none;border: 1px solid var(--black2);">
					<input type="submit" value="Nhập vào kho" class="submit_cate" style="height: 40px;border-radius: 40px;padding: 5px 20px;padding-left: 20px;padding-left: 35px;font-size: 18px;outline: none;background: #2a2185;border: 1px solid var(--black2);color: white;">
				</form>
			
			</div>

			<!-- List product category -->
			 <div class="details">
                <div class="recentOrders" style="display: block;">
                    <div class="cardHeader">
                        <h2>Các loại sản phẩm gần đây</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên loại</td>
                                <td>Cập nhật</td>
                            </tr>
                        </thead>

                        <tbody>
                       
                            
							<c:forEach var="item" items="${product_categorys}">
							  <tr>
                                <td>${item.nameCategory}</td>
								<td>
									<form action="ProductCategory" method="post">
										
										<input type="hidden" name="action" value="delete">
										<input type="hidden" name="namecate" value="<c:out value='${item.nameCategory}'/>">
										<input type="submit" value="Xóa" class="status delivered" style="background: red">
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