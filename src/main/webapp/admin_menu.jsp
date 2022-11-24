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
    
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  	<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
   <link rel="stylesheet" href="assets-admin/css/style_product.css">
</head>

<body>
    <!-- =============== Navigation ================ -->
        <div class="navigation">
            <ul>
                <li>
                    <a href="#">
                        <span class="icon">
                            <ion-icon name="logo-apple"></ion-icon>
                        </span>
                        <span class="title">Timup</span>
                    </a>
                </li>

                <li>
                    <a href="./admin.jsp">
                        <span class="icon">
                            <ion-icon name="home-outline"></ion-icon>
                        </span>
                        <span class="title">Trang chủ</span>
                    </a>
                </li>
				<li>
                    <a href="#">
                        <span class="icon">
                            <i class='bx bx-cart' style="font-size: 29px;"></i>
                        </span>
                        <span class="title">Đơn hàng</span>
                    </a>
                </li>
                <li>
                    <a href="UserServlet">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Người dùng</span>
                    </a>
                </li>

                <li>
                    <a href="ProductAdmin">
                        <span class="icon">
                            <i class='bx bxs-stopwatch' style="font-size: 29px;"></i>
                        </span>
                        <span class="title">Sản phẩm</span>
                    </a>
                </li>

                <li>
                    <a href="ProductCategory">
                        <span class="icon">
                            <i class='bx bx-category' style="font-size: 29px;"></i>
                        </span>
                        <span class="title">Loại sản phẩm</span>
                    </a>
                </li>

                <li>
                    <a href="ProviderServlet">
                        <span class="icon">
                            <i class='bx bx-import' style="font-size: 29px;"></i>
                        </span>
                        <span class="title">Nhà cung cấp</span>
                    </a>
                </li>

                

                <li>
                    <a href="#">
                        <span class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                        </span>
                        <span class="title">Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>

    <!-- =========== Scripts =========  -->
    <script src="assets/js/main.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>