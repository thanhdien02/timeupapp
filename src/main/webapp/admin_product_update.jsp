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
				<h2>Chỉnh sửa thông tin sản phẩm</h2>
				 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<c:if test="${kiemtra == 'datontai'}">
		        	<p style="color: red;margin-top: -35px;margin-bottom: 20px;margin-left: -255px;">Loại sản phẩm này đã có trong kho</p>
		   		 </c:if>
		   		 <form action="ProductAdmin" method="post">
					<div class="container-input">
						<div class="item-input">
							<label>Tên sản phẩm</label>
							<input type="text" value="${product.nameProduct }" required placeholder="Tên sản phẩm" class="name_cate" name="nameproduct">
						</div>
						<div class="item-input">
							<label>Loại sản phẩm</label>
							<input type="text" required value="${product.pd_category.nameCategory }" class="name_cate" name="namecategory">
						</div>
						<div class="item-input">
							<label>Giá sản phẩm</label>
							<input type="number" value="${product.price }" required placeholder="Giá" class="name_cate" name="priceproduct">
						</div>
						<div class="item-input">
							<label>Mô tả</label>
							<textarea name="desciptionproduct"  id="c_order_notes" cols="30" rows="5" class="form-control"
							
							style="
								padding: 5px 20px;
								padding-left: 20px;
								padding-left: 35px;
								font-size: 18px;
								outline: none;
								border: 1px solid var(--black2);
								flex: 1;"
							 placeholder="Viết mô tả vào đây...">${product.pd_specification.desciption }</textarea>
							<!-- <input type="text" required placeholder="Mô tả" class="name_cate" name="conditionproduct"> -->
						</div>
						<div class="item-input">
							<label>Màu sản phẩm</label>
							<input type="text" value="${product.pd_specification.color }" required placeholder="Màu sản phẩm" class="name_cate" name="colorproduct">
						</div>
						<div class="item-input">
							<label>Nguồn gốc</label>
							<input type="text" value="${product.pd_specification.origin }" required placeholder="Nguồn gốc" class="name_cate" name="originproduct">
						</div>
						
						<div class="item-input">
							<label>Trọng lượng</label>
							<input type="text" value="${product.pd_specification.weight }" required placeholder="Trọng lượng" class="name_cate" name="weightproduct">
						</div>
						<div class="item-input">
							<label>Kích thước màn hình</label>
							<input type="text" value="${product.pd_specification.sizeGreen }" required placeholder="Kích thước màn hình" class="name_cate" name="sizegreen">
						</div>
						
						<div class="item-input">
							<label>Thời lượng sử dụng</label>
							<input type="number" value="${product.pd_specification.use_time }" required placeholder="Thời lượng sử dụng" class="name_cate" name="usetimeproduct">
					</div>
					
					<div class="submit">
						<input type="hidden" value="updateproduct" name="action">
						<input type="hidden" value="${product.productId }" name="idproduct">
						<input type="submit" value="Chỉnh sửa " class="submit_cate">
					
					</div>
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