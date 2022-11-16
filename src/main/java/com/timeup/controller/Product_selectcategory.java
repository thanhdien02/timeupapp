package com.timeup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product_selectcatelory
 */
@WebServlet("/Product_selectcategory")
public class Product_selectcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "/admin.jsp";
		
		String action = request.getParameter("action");

		
		if(action.equals("insertproduct"))
		{
			
			String namecate = request.getParameter("namecate");

			request.setAttribute("namecate", namecate);
	
			url = "/admin_product_addnew.jsp";
			
		}
		
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);

	}

}
