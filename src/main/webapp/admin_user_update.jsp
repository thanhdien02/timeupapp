<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa thông tin khách hàng</title>
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
				<h2>Chỉnh sửa thông tin khách hàng</h2>
				 
				<form action="UserServlet" method="post">
					<div class="container-input" style="text-align: left;padding-left: 150px;">
						<div class="item-input" style="display: flex;padding-right: 265px;margin-bottom: 10px;margin-top: 10px;">
							<label style="flex: 0.4;align-self: center;font-size: 23px;">Họ và Tên khách hàng</label>
							<input type="text" name="fulname" style="flex: 1;" value="${user.fullName }" required placeholder="Tên sản phẩm" class="name_cate" >
						</div>
						<div class="item-input" style="display: flex;padding-right: 265px;margin-bottom: 10px;margin-top: 10px;">
							<label style="flex: 0.4;align-self: center;font-size: 23px;">Số điện thoại</label>
							<input type="text" name="numberphone" style="flex: 1;" required placeholder="Số điện thoại" value="${user.numberPhone }" class="name_cate" >
						</div>
						<div class="item-input" style="display: flex;padding-right: 265px;margin-bottom: 10px;margin-top: 10px;">
							<label style="flex: 0.4;align-self: center;font-size: 23px;">Email</label>
							<input type="text" name="email" style="flex: 1;" required placeholder="Email" value="${user.email }" class="name_cate" >
						</div>
					</div>
					<input type="hidden" name="action" value="update">
					<input type="hidden" name="iduser" value="${user.userId }">

					<input type="submit" style="margin-top: 40px;padding: 5px 80px;" value="Chỉnh sửa" class="submit_cate">
				</form>
			
			</div>
			
        
    </div>

    <!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>