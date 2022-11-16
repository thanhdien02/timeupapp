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
import com.timeup.dao.Product_categoryDAO;

/**
 * Servlet implementation class Product
 */
@MultipartConfig()
@WebServlet("/Product")
public class Product extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Xử lí thông tin bên trong đây 
		
		
		
		String url = "/admin.jsp";
		
		try {
			String action = request.getParameter("action");
			
			if(action.equals("loaddata"))
			{
				List<Product_category> product_categorys = Product_categoryDAO.selectProducts_categorys();
				
				request.setAttribute("product_categorys", product_categorys);
				url = "/admin_product_category.jsp";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		// Load loại sản phẩm lên lại. Làm sao cho nó gọn ràng hơn. Tổ chức code tốt hơn.
		
		// Lấy kinh nghiệm thực tế nhiều cái để học hơn. Chứ không phải như thế này
		

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

}
