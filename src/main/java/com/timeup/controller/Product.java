package com.timeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.timeup.business.*;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.Product_categoryDAO;
import com.timeup.dao.UserDAO;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "/shop.jsp";

		
		List<com.timeup.business.Product> products = ProductDAO.selectProducts();
		List<com.timeup.business.Product> pdl = new ArrayList<com.timeup.business.Product>();
		
		// Cate
		
		List<Product_category> product_categorys = Product_categoryDAO.selectProducts_categorys();
		String action = request.getParameter("action");
		if(product_categorys != null)
		{
			request.setAttribute("product_categorys", product_categorys);
		}
		
		// Product
		if(action.equals("nguoilon"))
		{
			
			
			for (com.timeup.business.Product product : products) {
				if(product.getCateAge().equals("adult"))
				{
					pdl.add(product);
				}
			}
			
			if(pdl != null)
			{
				request.setAttribute("products", pdl);
			}
				

			
			
		}
		else if(action.equals("treem"))
		{
			for (com.timeup.business.Product product : products) {
				if(product.getCateAge().equals("kid"))
				{
					pdl.add(product);
				}
			}
			
				
			if(pdl != null)
			{
				request.setAttribute("products", pdl);
			}

		}
		else 
		{
			// Phân loại theo hãng
			for (com.timeup.business.Product product : products) {
				if(product.getPd_category().getNameCategory().equals(action))
				{
					pdl.add(product);
				}
			}
			
			if(pdl != null)
			{				
				request.setAttribute("products", pdl);
			}
		}
		

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_user.jsp";
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<User> users = UserDAO.selectUsers();
		
		if(users != null)
		{
			request.setAttribute("users", users);
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

}
