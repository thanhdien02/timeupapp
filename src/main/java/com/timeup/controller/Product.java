package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product_category;
import com.timeup.business.*;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.Product_categoryDAO;

/**
 * Servlet implementation class Product
 */
@MultipartConfig()
@WebServlet("/Product")
public class Product extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/CartServlet";

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String url = "/CartServlet";

		getServletContext()	
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

}
