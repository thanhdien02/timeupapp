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

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/shop.jsp";
		
		List<Product> products = ProductDAO.selectProducts();
		
		if(products != null)
		{
			// Lấy 9 sản phẩm load lên home mà thôi
			
			int leght = products.size();
			
			if(leght > 9)
			{
				List<Product> productsnew = new ArrayList<Product>();
				
				int i = 0;
				for (Product product : products) {
					
					if(i == 9)
					{
						break;
					}
					productsnew.add(product);
					i++;
				}
				request.setAttribute("products", productsnew);
			}
			else 
			{				
				request.setAttribute("products", products);
			}
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

		doGet(request, response);
	}

}
