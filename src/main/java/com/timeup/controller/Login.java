package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        // Xử lí cookie lưu tài khoản và mật khẩu cho login.
		
		String url = "/login.jsp";
		
		Cookie []arr = request.getCookies();
		
		if(arr != null)
		{
			for (Cookie cookie : arr) {
				if(cookie.getName().equals("username"))
				{
					String username = cookie.getValue();
					request.setAttribute("username", username);
				}
				if(cookie.getName().equals("password"))
				{
					String password = cookie.getValue();
					request.setAttribute("password", password);
				}
			}
		}
		
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
				// Add cookie cho tài khoản và mật khẩu
//				HttpSession session = request.getSession();
//				
//				session.setAttribute("username", username);
//				session.setAttribute("password", password);
//				
				
		        Cookie userN = new Cookie("username", username);

		        userN.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
		        userN.setPath("/");                      // allow entire app to access it
		        response.addCookie(userN);
				
		        Cookie passW = new Cookie("password", password);
		        passW.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
		        passW.setPath("/");  
		        // allow entire app to access it
		        response.addCookie(passW);
		        
		        
				url = "/HomeServlet";
	
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
