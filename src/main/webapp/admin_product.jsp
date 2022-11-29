<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
  <link rel="stylesheet" href="assets-admin/css/style_product.css">
</head>

<body>
    <!-- =============== Navigation ================ -->
    <div class="container">
    
    <!-- Header -->
    <jsp:include page="admin_menu.jsp" /> 

        <!-- ========================= Main ==================== -->
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

            <!-- ======================= Cards ================== -->
            <div class="cardBox">
                <form action="ProductAdmin" method="post">
					<input type="hidden" name="action" value="load">
		            <input class="cardName" type="submit" value="Thêm sản phẩm" class="card" style="height: 100%;width: 100%;padding: 30px;border-radius: 20px;cursor: pointer;background: var(--blue);color: white;font-size: 23px;border: none;">                
	               
                </form>

               

                <div class="card">
                    <div>
                        <div class="numbers">$7,842</div>
                        <div class="cardName">Tổng danh thu</div>
                    </div>

                    <div class="iconBx">
                        <ion-icon name="cash-outline"></ion-icon>
                    </div>
                </div>
            </div>

            <!-- ================ Order Details List ================= -->
            <div class="details">
                <div class="recentOrders" style="display: block;">
                    <div class="cardHeader">
                        <h2>Sản phẩm gần đây</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Tên</td>
                                <td>Giá</td>
                                <td>Số lượng còn</td>
                                <td>Loại sản phẩm</td>
                            </tr>
                        </thead>

                        <tbody>
                        
                        	<c:forEach var="item" items="${products}">
							  <tr>
                                <td>${item.nameProduct}</td>
                                <td>
                                	<fmt:setLocale value = "vi_VN"/>
	                    			<fmt:formatNumber value = "${item.price}" type = "currency"/>
                                
                                </td>
                                <td>${item.number_remain}</td>

								<td>
								
									<img alt="" src="${item.products_image[0].image_path}" style="width: 100px;">

								</td>
								
                                
                            </tr>
							</c:forEach>

                      
                        </tbody>
                    </table>
                </div>

               
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