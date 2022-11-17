package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product_category;
import com.timeup.business.Product;
import com.timeup.business.Product_specification;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.Product_categoryDAO;
import com.timeup.dao.Product_specificationDAO;

/**
 * Servlet implementation class ProductAdmin
 */
@WebServlet("/ProductAdmin")
public class ProductAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/admin.jsp";
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin.jsp";
		
		String action = "";
		action =request.getParameter("action");
			

		
		if(action.equals("load"))
		{
			try {
				List<Product_category> product_categorys = Product_categoryDAO.selectProducts_categorys();
				
				request.setAttribute("product_categorys", product_categorys);
			}catch (Exception e) {
				// TODO: handle exception
			}

			url = "/admin_product_selectcategory.jsp";
		}
//		
//		
		if(action.equals("addproduct"))
		{
			// Thong so ky thuat 
			Product_specification pdspecification = new Product_specification();
			String color = request.getParameter("colorproduct");
			String origin = request.getParameter("originproduct");
			String usetime = request.getParameter("usetimeproduct");
			pdspecification.setColor(color);
			pdspecification.setOrigin(origin);
			pdspecification.setUse_time(usetime);
			
			Product_specificationDAO pdspecificationDao = new Product_specificationDAO();
			
			pdspecificationDao.insert(pdspecification);
			
			
			// sp
			Product product = new Product();
			ProductDAO productDAO = new ProductDAO();
			String namepd = request.getParameter("nameproduct");
			Long price = Long.parseLong(request.getParameter("priceproduct"));
			String condition = request.getParameter("conditionproduct");
			Long number_remain = Long.parseLong(request.getParameter("number_product"));
			
			product.setNameProduct(namepd);
			product.setNumber_remain(number_remain);
			product.setPrice(price);
			
			// Cate
			String namecate = request.getParameter("namecategory");
			Product_category pdcate = Product_categoryDAO.selectOneByName(namecate);
			product.setPd_category(pdcate);
			
			// specifi
			Product_specification pdspeci = new Product_specification();
			pdspeci = Product_specificationDAO.selectOneByName(color, usetime, origin);
			
			
			product.setPd_specification(pdspeci);
			
			request.setAttribute("productadd", product);
			
			
			productDAO.insert(product);
			url = "/admin_product_image.jsp";
		
		}
//		
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}


}
