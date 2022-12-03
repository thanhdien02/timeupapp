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
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_product.jsp";
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Product> products = ProductDAO.selectProducts();
		
		if(products != null)
		{
			request.setAttribute("products", products);
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/admin.jsp";
		
		String action =request.getParameter("action");
		
		if(action.equals("fwadmin"))
		{
			doGet(request, response);
		}

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
			String description = request.getParameter("desciptionproduct");
			String sizegreen = request.getParameter("sizegreen");
			String weight = request.getParameter("weightproduct");
			pdspecification.setColor(color);
			pdspecification.setOrigin(origin);
			pdspecification.setUse_time(usetime);
			pdspecification.setDesciption(description);
			pdspecification.setSizeGreen(sizegreen);
			pdspecification.setWeight(weight);
			
			Product_specificationDAO pdspecificationDao = new Product_specificationDAO();
			
			pdspecificationDao.insert(pdspecification);
			
			
			// sp
			Product product = new Product();
			ProductDAO productDAO = new ProductDAO();
			String namepd = request.getParameter("nameproduct");
			String intendedfor = request.getParameter("intendedfor");
			Long price = Long.parseLong(request.getParameter("priceproduct"));
			Long number_remain = Long.parseLong(request.getParameter("number_product"));
			
			product.setNameProduct(namepd);
			product.setNumber_remain(number_remain);
			product.setPrice(price);
			if(intendedfor.equals("adult"))
			{
				intendedfor = "adult";
			}
			else 
			{
				intendedfor = "kid";
			}
			product.setCateAge(intendedfor);
			
			// Loại sản phẩm
			String namecate = request.getParameter("namecategory");
			Product_category pdcate = Product_categoryDAO.selectOneByName(namecate);
			product.setPd_category(pdcate);
			
			// specifition
//			Product_specification pdspeci = new Product_specification();
//			pdspeci = Product_specificationDAO.selectOneByName(color, usetime, origin);
			
			
			product.setPd_specification(pdspecification);
			
			request.setAttribute("productadd", product);
			
			
			productDAO.insert(product);
			url = "/admin_product_image.jsp";
		
		}
		
		if(action.equals("loaddateforwardupdate"))
		{
			
			String idproduct = request.getParameter("idproduct");
			Long id = Long.parseLong(idproduct);
			
			Product product = ProductDAO.selectById(id);
			if(product != null)
			{
				request.setAttribute("product", product);
			}
			url = "/admin_product_update.jsp";
			
		}
		
		if(action.equals("updateproduct"))
		{
			
			// Loại sản phẩm
			String idcate = request.getParameter("idproductcategory");
			Long idct = Long.parseLong(idcate);
			
			Product_category product_cate = Product_categoryDAO.selectById(idct);
			
			// Cập nhật loại sản phẩm
			if(product_cate != null)
			{
				String namecate = request.getParameter("namecategory");
				product_cate.setNameCategory(namecate);
				
				Product_categoryDAO pdcatedao = new Product_categoryDAO();
				pdcatedao.update(product_cate);
			}
			
			
			// Cập nhật thông số kỹ thuật
			
			String idspecification = request.getParameter("idproductspecifi");
			Long idspecifi = Long.parseLong(idspecification);
			
			Product_specification pdspecificationnew = Product_specificationDAO.selectById(idspecifi);
			
			if(pdspecificationnew != null)
			{
				
				String color = request.getParameter("colorproduct");
				String origin = request.getParameter("originproduct");
				String usetime = request.getParameter("usetimeproduct");
				String description = request.getParameter("desciptionproduct");
				String sizegreen = request.getParameter("sizegreen");
				String weight = request.getParameter("weightproduct");
				
				pdspecificationnew.setColor(color);
				pdspecificationnew.setDesciption(description);
				pdspecificationnew.setOrigin(origin);
				pdspecificationnew.setUse_time(usetime);
				pdspecificationnew.setWeight(weight);
				pdspecificationnew.setSizeGreen(sizegreen);
				
				Product_specificationDAO pdspecifidao = new Product_specificationDAO();
				
				pdspecifidao.update(pdspecificationnew);
				
			}
			
			
			// Cập nhật product

			String idproduct = request.getParameter("idproduct");
			Long id = Long.parseLong(idproduct);
			
			Product product = ProductDAO.selectById(id);
			
			if(product != null)
			{
				// Lấy dữ liệu xuống.
				String namepd = request.getParameter("nameproduct");
				Long price = Long.parseLong(request.getParameter("priceproduct"));
				
				product.setPrice(price);
				product.setNameProduct(namepd);
				
				ProductDAO productdao = new ProductDAO();
				productdao.update(product);
			}
			
			
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			
			List<Product> products = ProductDAO.selectProducts();
			
			if(products != null)
			{
				request.setAttribute("products", products);
			}
			url = "/admin_product.jsp";
		}		
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}
}
