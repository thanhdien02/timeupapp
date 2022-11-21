<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,600,0,0" />
    <link rel="stylesheet" href="css/cssregis/style.css" />
      <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
    <title>Login SmartWatch</title>
</head>

<body>

    <div class="container">
        <div class="login-left">
            <div class="login-header">
                <h1>Welcome to Store SmartWatch 1112222</h1>
                <p>Please login to use the Application</p>
            </div>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
		    <c:if test="${kiemtralogin == 'sai'}">
		        <p style="color:red;margin-top:-20px;">Tài khoản hoặc mật khẩu không chính xác</p>
		    </c:if> 
            <form class="login-form" autocomplete="off" action="Login" method="post">
                <div class="login-form-content">
                    <div class="form-item">
                        <label for="emailForm">Enter User xin chao 222 <c:out value="${iditem}"></c:out></label>
                        <input type="text" id="emailForm"  value="${username }" name ="username" required>
                    </div>
                    <div class="form-item">
                        <label for="passwordForm">Enter Password</label>
                        <input type="password" id="passwordForm"  value="${password }" name ="password" required>
                    </div>
                    <div class="remember-regis">
                        <div class="checkbox">
                            <input type="checkbox" id="rememberMeCheckbox" checked>
                            <label class="checkboxLabel" for="rememberMeCheckbox">Remember me</label>
                        </div>
                        <div class="regis">
                        	<a href="./register.jsp">Register Account</a>
                        </div>
                    </div>
                    <button type="submit">Sign In</button>
                </div>
                <div class="login-form-footer">
                    <a href="#">
                        <img width="30"
                            src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/1365px-Facebook_f_logo_%282019%29.svg.png">
                        Facebook Login
                    </a>
                    <a href="#">
                        <img width="30"
                            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK5q0FP74VV9wbfwP378_7kj7iDomHuKrxkXsxDdUT28V9dlVMNUe-EMzaLwaFhneeuZI&usqp=CAU">
                        Google Login
                    </a>
                </div>
            </form>
        </div>
        <div class="login-right">
            <img src="./images/img/smartwatch-svgrepo-com.svg" alt="image">
        </div>
    </div>
</body>

</html>