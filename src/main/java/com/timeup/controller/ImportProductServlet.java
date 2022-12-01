package com.timeup.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Import_Product;
import com.timeup.business.Product;
import com.timeup.business.Provider;
import com.timeup.dao.ImportProductDAO;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.ProviderDAO;


@WebServlet("/ImportProductServlet")
public class ImportProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/admin.jsp";
		
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
		String action = request.getParameter("action");
		
		
		// Load thông tin sản phẩm lên trang để nhập thêm sản phẩm vào kho
		if(action.equals("importproduct"))
		{
			String idimportproduct = request.getParameter("idimportproduct");
			Long id = Long.parseLong(idimportproduct);
			
			Product product = ProductDAO.selectById(id);
			
			List<Provider> providers = ProviderDAO.selectProviders();
			request.setAttribute("providers", providers);
			if(product != null)
			{
				request.setAttribute("product", product);
				url = "/admin_import.jsp";
				getServletContext()
		        .getRequestDispatcher(url)
		        .forward(request, response); // Chuyen trang 
			}
			
			
		}
		
		if(action.equals("updatenumberproduct"))
		{
			String idimportproduct = request.getParameter("idproduct");
			String number = request.getParameter("numberadd");
			
			// Cộng thêm cái cũ vào nữa
			Long slimport = Long.parseLong(number);
			Long id1 = Long.parseLong(idimportproduct);
			
			Product product = ProductDAO.selectById(id1);
			
			
			
			Import_Product importproduct = new Import_Product();
			
			// Lấy nhà cung cấp
			
			String idprovider = request.getParameter("idprovider");
			Long idpvd = Long.parseLong(idprovider);
			
			
			ImportProductDAO importproductDAO = new ImportProductDAO();
			Provider provider = ProviderDAO.selectById(idpvd);
			
			importproduct.setDate_import(LocalDateTime.now());
			importproduct.setProduct(product);
			importproduct.setProvider(provider);
			importproduct.setNumberImport(slimport);
			// Nhập thêm vào
			importproductDAO.insert(importproduct);
			
			if(product != null)
			{
				Long numbernow = product.getNumber_remain();
				numbernow += slimport;
				
				//Cập nhập lại
				product.setNumber_remain(numbernow);
				ProductDAO productdao = new ProductDAO();
				
				productdao.update(product);
				
				List<Product> products = ProductDAO.selectProducts();
				
				if(products != null)
				{
					request.setAttribute("products", products);
				}
				
				url = "/admin.jsp";
				getServletContext()
		        .getRequestDispatcher(url)
		        .forward(request, response); // Chuyen trang 
			}
		}

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); // Chuyen trang 
	}

}
