package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product;
import com.timeup.business.Product_category;
import com.timeup.dao.Product_categoryDAO;

/**
 * Servlet implementation class ProductCategory
 */
@WebServlet("/ProductCategory")
public class ProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String url = "/admin_product_category.jsp";
		
		List<Product_category> product_categorys = Product_categoryDAO.selectProducts_categorys();
		request.setAttribute("product_categorys", product_categorys);
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_product_category.jsp";
		
		// Lấy cái sự kiện của nó xem nò làm gì và điều chỉnh nó sao cho phù hợp nhất.

		String action =	request.getParameter("action");

		
		
		List<Product_category> product_categorys = Product_categoryDAO.selectProducts_categorys();
		
		if(product_categorys != null)
		{
			request.setAttribute("product_categorys", product_categorys);
		}
		
		// Thêm kiểm tra điều kiện là nó không được trùng tê
		if(action.equals("add"))
		{
			String namecate = request.getParameter("namecategory");
			Product_category pdcate = new Product_category();
			
			pdcate.setNameCategory(namecate);
			int test = 0;
			
			// Kiểm tra để tên của loại sản phẩm khi thêm vào không bị trùng
			if(product_categorys != null)
			{
				for (Product_category product_category : product_categorys) {
					if(namecate.equals(product_category.getNameCategory()))
					{
						test = 1;
						String kiemtra = "datontai";
						request.setAttribute("kiemtra", kiemtra);
						
						url = "/admin_product_category.jsp";
					}
				}
			}
			 
			if(test == 0) // Nếu không có trong kho sẽ thêm vào bên trong đó
			{
				Product_categoryDAO pdcateDAO = new Product_categoryDAO();
				pdcateDAO.insert(pdcate);
				List<Product_category> product_categorys1 = Product_categoryDAO.selectProducts_categorys();
				
				request.setAttribute("product_categorys", product_categorys1);
			}
		}
		
		
		// Xóa 1 loại sản phẩm
		if(action.equals("delete"))
		{
			String namecate = request.getParameter("namecategory");
			Product_category pdcate = new Product_category();
			
			pdcate.setNameCategory(namecate);
			// No lấy cái gì để nó xóa
			// Lấy name để xóa lưu set cho nó qua bên đây lấy lại.
			namecate = request.getParameter("namecate");
			// Tìm thông qua tên của nó
			Product_category pdct = new Product_category();
			pdct = Product_categoryDAO.selectOneByName(namecate);
			
			Product_categoryDAO pd = new Product_categoryDAO();
			pd.delete(pdct);
			List<Product_category> product_categorys1 = Product_categoryDAO.selectProducts_categorys();
			
			request.setAttribute("product_categorys", product_categorys1);
			url = "/admin_product_category.jsp";
		}
		
		// Kiểm tra loại sản phẩm thêm vào không được trùng nhau.
		
		if(action.equals("loaddataforwordupdate"))
		{
			
			String idcate = request.getParameter("idcate");
			String namecategory = request.getParameter("namecate");
			
			request.setAttribute("idcate", idcate);
			request.setAttribute("namecategory", namecategory);
			
			
			url = "/admin_category_update.jsp";

			
		}
		
		
		if(action.equals("update"))
		{
			String idcate = request.getParameter("idcate");
			String namecategory = request.getParameter("namecategory");
			Long id = Long.parseLong(idcate);
			
			Product_category product_cate = Product_categoryDAO.selectById(id);
			if(product_cate != null)
			{
				// Cập nhật lại tên của nó 
				product_cate.setNameCategory(namecategory);
				
				
				// Cập nhật
				Product_categoryDAO product_cateDAO = new Product_categoryDAO();
				product_cateDAO.update(product_cate);
				
				
			}
			
			List<Product_category> product_categorys1 = Product_categoryDAO.selectProducts_categorys();
			
			request.setAttribute("product_categorys", product_categorys1);
			url = "/admin_product_category.jsp";
		}
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
		
		
		
	}

}
