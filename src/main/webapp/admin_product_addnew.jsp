<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
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
				<h2>Thêm sản phẩm mới</h2>
				 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<c:if test="${kiemtra == 'datontai'}">
		        	<p style="color: red;margin-top: -35px;margin-bottom: 20px;margin-left: -255px;">Loại sản phẩm này đã có trong kho</p>
		   		 </c:if>
		   		 <form action="ProductAdmin" method="post">
					<div class="container-input">
						<div class="item-input">
							<label>Tên sản phẩm</label>
							<input type="text" required placeholder="Tên sản phẩm" class="name_cate" name="nameproduct">
						</div>
						<div class="item-input">
							<label>Loại sản phẩm</label>
							<input type="text" required value="${namecate}" class="name_cate" name="namecategory">
						</div>
						<div class="item-input">
							<label>Giá sản phẩm</label>
							<input type="number" required placeholder="Giá" class="name_cate" name="priceproduct">
						</div>
						<div class="item-input">
							<label>Mô tả</label>
							<input type="text" required placeholder="Mô tả" class="name_cate" name="conditionproduct">
						</div>
						<div class="item-input">
							<label>Màu sản phẩm</label>
							<input type="text" required placeholder="Màu sản phẩm" class="name_cate" name="colorproduct">
						</div>
						<div class="item-input">
							<label>Nguồn gốc</label>
							<input type="text" required placeholder="Nguồn gốc" class="name_cate" name="originproduct">
						</div>
						<div class="item-input">
							<label>Thời lượng sử dụng</label>
							<input type="number" required placeholder="Thời lượng sử dụng" class="name_cate" name="usetimeproduct">
						</div>
						<div class="item-input">
							<label>Số lượng thêm</label>
							<input type="number" required placeholder="Giá" class="name_cate" name="number_product">
						</div>
						
					</div>
					
					<div class="submit">
						<input type="hidden" value="addproduct" name="action">
						<input type="submit" value="Thêm sản phẩm" class="submit_cate">
					
					</div>
				</form>
			
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
                                <td>Tên loại</td>
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
									<form action="ProductCategory" method="post">
										
										<input type="hidden" name="action" value="delete">
										<input type="hidden" name="namecate" value="<c:out value='${item.nameCategory}'/>">
										<input type="submit" value="Xóa" class="status delivered">
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