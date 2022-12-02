package com.timeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.User;
import com.timeup.business.Product;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.UserDAO;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String url = "/admin_user.jsp";
		List<User> users =  UserDAO.selectUsers();
		if(users != null)
		{
			request.setAttribute("users", users);
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_user.jsp";
		
		
		String action = request.getParameter("action");
		if(action.equals("delete"))
		{
			String iduser = request.getParameter("iduser");
			Long id = Long.parseLong(iduser);
			
			User user = UserDAO.selectById(id);
			
			UserDAO.delete(user);
			
			// Load loại dữ liệu
			List<User> users =  UserDAO.selectUsers();
			if(users != null)
			{
				request.setAttribute("users", users);
			}
			
			
		}
		
		if(action.equals("loaddateforwardupdate"))
		{
			String iduser = request.getParameter("iduser");
			Long id = Long.parseLong(iduser);
			
			User user = UserDAO.selectById(id);
			
			if(user != null)
			{
				request.setAttribute("user", user);
			}
			url = "/admin_user_update.jsp";
		}
		
		if(action.equals("update"))
		{
			String iduser = request.getParameter("iduser");
			String fullname = request.getParameter("fulname");
			String numberphone = request.getParameter("numberphone");
			String email = request.getParameter("email");
			Long id = Long.parseLong(iduser);
			
			User user = UserDAO.selectById(id);
			
			// Cập nhật lại
			user.setNumberPhone(numberphone);
			user.setEmail(email);
			user.setFullName(fullname);
			
			UserDAO.update(user);
			
			List<User> users =  UserDAO.selectUsers();
			if(users != null)
			{
				request.setAttribute("users", users);
			}
			url = "/admin_user.jsp";
			
		}
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); 
	}

}
