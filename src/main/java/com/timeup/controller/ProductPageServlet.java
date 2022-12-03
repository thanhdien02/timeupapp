package com.timeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product;
import com.timeup.business.Product_category;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.Product_categoryDAO;

/**
 * Servlet implementation class ProductPageServlet
 */
@WebServlet("/ProductPageServlet")
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/shop.jsp";
		
		List<Product> products = ProductDAO.selectProducts();
		//
		int length = products.size();
		
		// Kiểm tr phân bao nhiêu trang 
		int numberpage = length / 9;
		if(length % 9 != 0)
		{
			numberpage++;
		}
		request.setAttribute("end", numberpage);
		
		//
		List<Product> productsnew = new ArrayList<Product>();
		String action = request.getParameter("action");
		if(action.equals("page"))
		{
			int index = Integer.parseInt(request.getParameter("index"));
			
			int gan = (index  *9) - 9;
			for(int j = gan; j < gan + 9; j++)
			{
				if(length > j)
				{
					productsnew.add(products.get(j));
				}


			}
			request.setAttribute("products", productsnew);
		}
		
		
		List<Product_category> product_categorys = Product_categoryDAO.selectProducts_categorys();
		if(product_categorys != null)
		{
			request.setAttribute("product_categorys", product_categorys);
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
