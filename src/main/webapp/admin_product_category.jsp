<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h2>Thêm loại sản phẩm mới</h2>
				 
				<c:if test="${kiemtra == 'datontai'}">
		        	<p style="color: red;margin-top: -35px;margin-bottom: 20px;margin-left: -255px;">Loại sản phẩm này đã có trong kho</p>
		   		 </c:if>
				<form action="ProductCategory" method="post">
					<input type="hidden" name="action" value="add">
					<input type="text" required placeholder="Tên loại sản phẩm" class="name_cate" name="namecategory">
					<input type="submit" value="Thêm loại sản phẩm" class="submit_cate">
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
                                <td>Xóa</td>
                            </tr>
                        </thead>

                        <tbody>
                       
                            
							<c:forEach var="item" items="${product_categorys}">
							  <tr>
                                <td>${item.nameCategory}</td>
								<td>
									<form action="ProductCategory" method="post">			
										<input type="hidden" name="action" value="loaddataforwordupdate">							
										<input type="hidden" name="idcate" value="<c:out value='${item.pd_cateId}'/>">
										<input type="hidden" name="namecate" value="<c:out value='${item.nameCategory}'/>">
										<input type="submit" value="Chỉnh sửa" class="status delivered" style="background: #8de02c;width: 100px;height: 30px;">
									</form>
								</td>
								<td>
									<form action="ProductCategory" method="post">
										<input type="hidden" name="action" value="delete">
										<input type="hidden" name="idcate" value="<c:out value='${item.pd_cateId}'/>">
										<input type="hidden" name="namecate" value="<c:out value='${item.nameCategory}'/>">
										<input type="submit" value="Xóa" class="status delivered" style="background: red;width: 100px;height: 30px;">
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