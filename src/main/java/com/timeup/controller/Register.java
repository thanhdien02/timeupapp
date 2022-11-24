package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.User;
import com.timeup.dao.UserDAO;
import com.timeup.data.DBUtil;


@WebServlet("/Register")
public class Register extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/login.jsp";
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "";
		
		String username = request.getParameter("username");	
		String email = request.getParameter("email");	
		String password = request.getParameter("password");	
		String passwordCF = request.getParameter("passwordconfirm");
		
		User user = new User();
		user.setEmail(email);
		user.setNameLogin(username);
		user.setPassword(password);

		 //Kiểm tra pass và pass xác nhận giống nhau
		if(!password.equals(passwordCF))
		{
			url = "/register.jsp";
			String check = "sai";
			request.setAttribute("check", check);
			getServletContext()
	        .getRequestDispatcher(url)
	        .forward(request, response); // Tro lai trang dang ky va keu nhap lai
		}
		
		// Kiểm tra tên tài khoản đăng nhập có trong db chưa
	
		List<User> users =  UserDAO.selectUsers();
		if(users != null)
		{
			for (User us : users) {
				System.out.print(us.getNameLogin());
				if(us.getNameLogin().equals(username))
				{
					String kiemtra = "sai";
					request.setAttribute("kiemtra", kiemtra);
					url = "/register.jsp"; 
					getServletContext()
			        .getRequestDispatcher(url)
			        .forward(request, response); // Tro lai trang dang ky va keu nhap lai
					return;
				}
			}	
		}

		
		UserDAO.insert(user);
		url = "/login.jsp";
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	
	}
}
