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
  <link rel="stylesheet" href="./assets-admin/css/style_product_category.css">
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
				<h2>Lựa chọn loại sản phẩm của sản phẩm thêm vào</h2>
				 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				
			
			</div>
			
			
			<!-- List product category -->
			 <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Sản phẩm gần đây</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên 11</td>
                                <td>Giá</td>
                                <td>Số lượng còn</td>
                                <td>Cập nhật</td>
                            </tr>
                        </thead>

                        <tbody>
                       
                            
							<c:forEach var="item" items="${product_categorys}">
							  <tr>
                                <td>${item.nameCategory}</td>
                                <td>$1200</td>
                                <td>Paid</td>

								<td>
									<form action="Product_selectcategory" method="post">
										
										<input type="hidden" name="action" value="insertproduct"> <!-- Lấy cái tên của nó ra rồi đi select là được -->
										<input type="hidden" name="namecate" value="<c:out value='${item.nameCategory}'/>">
										<input type="submit" value="Chọn" class="status delivered">
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