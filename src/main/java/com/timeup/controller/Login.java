package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product;
import com.timeup.business.User;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String url = "/index.jsp";
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<User> users =  UserDAO.selectUsers();
		
		if(users == null)
		{
			url = "/register.jsp"; // Mật khẩu sai

			getServletContext()
	        .getRequestDispatcher(url)
	        .forward(request, response);
		}
		for (User user : users) {
			if(user.getNameLogin().equals(username) && user.getPassword().equals(password))
			{
				
				// Nếu thành công load product lên trang home của nó. 
				// Đăng nhập bình thường nó cũng load rồi
				
				// Thiết kế trang dashboarh của nó
				// Hoàn thành cái product này cho xong của nó luôn 
				// Phong cách code riêng của mỗi người, lấy APi của nó như thế nào
				// Lấy danh sách của product. Sau đó cho nó load ra trang của home đưa các sản phẩm của nó ra bên ngoài đó 
				// Thêm sản phẩm, thông tin.
				// Cái này có chức năng là.Khi nhắn vào bên trong đó nó sẽ hiện ra như thế này nè hiểu chưa nào
				
				
				
				url = "/admin.jsp";
				
				getServletContext()
		        .getRequestDispatcher(url)
		        .forward(request, response);
			}

		}
		
		String kiemtra = "sai";
		request.setAttribute("kiemtralogin", kiemtra);
		url = "/login.jsp"; // Mật khẩu sai

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

}
