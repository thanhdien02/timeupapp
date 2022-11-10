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
    <link rel="shortcut icon" href="./favicon.png" type="image/x-icon">
        <link rel="stylesheet" href="css/cssregis/register_style.css" />
    <title>Register SmartWatch</title>
</head>

<body>

    <div class="container">
        <div class="login-left">
            <div class="login-header">
                <h1>Welcome to page Register</h1>
                <p>Please fill in the information</p>
            </div>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		    <c:if test="${check == 'sai'}">
		        <p style="color:red;margin-top:-20px;">Mật khẩu không trùng nhau</p>
		    </c:if>    

		    <c:if test="${kiemtra == 'sai'}">
		        <p style="color:red;margin-top:-20px;">Tài khoản này đã tồn tại</p>
		    </c:if>  
            <form class="login-form" autocomplete="off" action="Register" method="post">

                <div class="login-form-content">
                    <div class="form-item">
                        <label for="emailForm">Enter User Name</label>
                        <input type="text" id="emailForm" name="username" required>
                    </div>
                    <div class="form-item">
                        <label for="emailForm">Enter Email</label>
                        <input type="text" id="emailForm" name="email" required>
                    </div>
                    <div class="form-item">
                        <label for="emailForm">Enter Password</label>
                        <input type="password" name="password" required>
                    </div>
                    <div class="form-item">
                        <label for="passwordForm">Confirm Password</label>
                        <input type="password" name="passwordconfirm" required>
                    </div>
                    
                    <input type="submit" value="Register" class="sbmit">
                </div>
            </form>
        </div>
        <div class="login-right">
            <img src="./images/img/smartwatch-svgrepo-com.svg" alt="image">
        </div>
    </div>

</body>

</html>