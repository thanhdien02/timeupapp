package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.dao.ProductDAO;
import com.timeup.business.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		request.setCharacterEncoding("UTF-8");
		String url = "/login.jsp";
		
		try {
			String pdid = request.getParameter("id");

			Long id = Long.parseLong(pdid);
			
			Product product = ProductDAO.selectById(id);
			
			request.setAttribute("product", product);
			url = "/product_detail.jsp";
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

		List<Product> products = ProductDAO.selectProducts();
		
		if(products != null)
		{
			request.setAttribute("products", products);
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/login.jsp";
		
		try {
			String pdid = request.getParameter("id");

			Long id = Long.parseLong(pdid);
			
			Product product = ProductDAO.selectById(id);
			
			request.setAttribute("product", product);
			url = "/product_detail.jsp";
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

}
