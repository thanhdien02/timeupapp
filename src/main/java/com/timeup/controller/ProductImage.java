package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product;
import com.timeup.business.Product_image;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.Product_imageDAO;

/**
 * Servlet implementation class ProductImage
 */
@WebServlet("/ProductImage")
public class ProductImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/admin.jsp";
		
		String action = request.getParameter("action");
		
		if(action.equals("addimage"))
		{
			String path_url = request.getParameter("path_image");
			
			Product_imageDAO product_imageDAO = new Product_imageDAO();
			Product_image product_image = new Product_image();
			
			product_image.setImage_path(path_url);
			// Lấy product add vào bên đây
			
			// Thông qua tên và giá sẽ lấy sản phẩm đó ra.
			// Cập nhật một sản phẩm.
			
			String nameproduct = request.getParameter("nameproduct");
			String price = request.getParameter("priceproduct");
			Product product = new Product();
			
			Long p = Long.parseLong(price);
			product = ProductDAO.selectOneByName(nameproduct, p);
			
			product_image.setProduct(product);
			
			request.setAttribute("productadd", product);
			// add
			product_imageDAO.insert(product_image);
			
			
			List<Product_image> product_images = Product_imageDAO.selectProducts_images();
			
			
			if(product_images != null)
			{
				request.setAttribute("product_images", product_images);
			}
			
			
			url = "/admin_product_image.jsp";
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

}
