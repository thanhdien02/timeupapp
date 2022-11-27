package com.timeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import org.apache.tomcat.util.http.ServerCookie;

import com.timeup.data.CookieUtil;
import com.timeup.business.Product;
import com.timeup.dao.ProductDAO;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/cart.jsp";
		Cookie []arr = request.getCookies();
		List<Product> products = new ArrayList<>();
		
		String pdid = CookieUtil.getCookieValue(arr, "id");
		
		if(!pdid.equals(""))
		{
			
			// Xóa dấu phẩy cuối chuỗi id
			String idl = removeLastChar(pdid);
			
			String listid[] = pdid.split("@");
			
			
			Long tongcart = (long) 0;
 			for (String string : listid) {
				
				// Tìm sản phẩm qua id
				Long longid = Long.parseLong(string);
				Product product = ProductDAO.selectById(longid);
				
				
				for(Cookie cookie: arr)
				{
					if(string.equals(cookie.getName()))
					{
						
						// Xử lí để lấy và đưa số lượng sản phẩm lên trên đó. 
						//storequatity.add(Integer.parseInt(string));
						if(product != null)
						{
							// Lấy quantity trong cookie
							Long quatity = Long.parseLong(cookie.getValue());
							product.setQuatity(quatity);
							
							// Cập nhật nó vào db
							//ProductDAO pddao = new ProductDAO();
							//pddao.update(product);
							
							long tong1product = quatity* product.getPrice();
							
							tongcart += tong1product;
							products.add(product);
						}
						
					}
				}
				
			}
			
			// Lấy mảng cookie.
			//request.setAttribute("quatityproducts", storequatity);
 			request.setAttribute("sumcart", tongcart);
			request.setAttribute("products", products);
		}
		url = "/cart.jsp";
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/admin.jsp";
		

		Cookie []arr = request.getCookies();
		
		// Kiểm tra xem cookie cart đã tạo được chưa.
		String str_id = CookieUtil.getCookieValue(arr, "id");
		
		// Delete product trong giỏ hàng
		String action = request.getParameter("action");
		
		if(action.equals("detelecartproduct"))
		{
			String iddelete = request.getParameter("iddelete");
			
			// Chắc chắn là có bên trong đó rồi.
			iddelete +="@";
			String lid = CookieUtil.getCookieValue(arr, "id");
			String idnew = lid.replace(iddelete, "");
			
			Cookie ID = new Cookie("id", idnew);

	        ID.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
	        ID.setPath("/");                      // allow entire app to access it
	        response.addCookie(ID);
	        //doGet(request, response);
	        
	        
	        //
	        
			List<Product> products = new ArrayList<>();
			
			// Load lại trang
			if(!idnew.equals(""))
			{
				
				// Xóa dấu phẩy cuối chuỗi id
				String idl = removeLastChar(idnew);
				
				String listid[] = idnew.split("@");
				for (String string : listid) {
					
					// Tìm sản phẩm qua id
					Long longid = Long.parseLong(string);
					Product product = ProductDAO.selectById(longid);
					//products.add(product);
					for(Cookie cookie: arr)
					{
						if(string.equals(cookie.getName()))
						{
							
							// Xử lí để lấy và đưa số lượng sản phẩm lên trên đó. 
							//storequatity.add(Integer.parseInt(string));
							if(product != null)
							{
								// Lấy quantity trong cookie
								Long quatity = Long.parseLong(cookie.getValue());
								product.setQuatity(quatity);
								
								// Cập nhật nó vào db
								//ProductDAO pddao = new ProductDAO();
								//pddao.update(product);
								
								products.add(product);
								break;
							}
							
						}
					}
				}
				request.setAttribute("products", products);
			}
			url = "/cart.jsp";
			getServletContext()
	        .getRequestDispatcher(url)
	        .forward(request, response);	
			return;
	        //
		}
		// Cập nhật giỏ hàng. Mỗi lần chỉ cập nhật 1 sản phẩm mà thôi
		
		if(action.equals("updateproduct"))
		{

			String id = request.getParameter("idupdate");
			
			// Cập nhật vào cookie và load dữ liệu lại

			 String quantt = request.getParameter("quatitycart");
		     Cookie sl = new Cookie(id, quantt);

		     sl.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
		     sl.setPath("/");                      // allow entire app to access it
		     response.addCookie(sl);
			
		     
		     
				List<Product> products = new ArrayList<>();
				
				String pdid = CookieUtil.getCookieValue(arr, "id");
				
				if(!pdid.equals(""))
				{
					
					// Xóa dấu phẩy cuối chuỗi id
					String idl = removeLastChar(pdid);
					
					String listid[] = pdid.split("@");
					
					
					Long tongcart = (long) 0;
		 			for (String string : listid) {
						
						// Tìm sản phẩm qua id
						Long longid = Long.parseLong(string);
						Product product = ProductDAO.selectById(longid);
						
						
						for(Cookie cookie: arr)
						{
							if(string.equals(cookie.getName()))
							{
								
								// Xử lí để lấy và đưa số lượng sản phẩm lên trên đó. 
								//storequatity.add(Integer.parseInt(string));
								if(product != null)
								{
									if(id.equals(string))
									{
										// Lấy quantity trong cookie
										Long quatity = Long.parseLong(quantt);
										product.setQuatity(quatity);
										
										// Cập nhật nó vào db
										//ProductDAO pddao = new ProductDAO();
										//pddao.update(product);
										
										long tong1product = quatity* product.getPrice();
										
										tongcart += tong1product;
										products.add(product);
										
									}
									else
									{
										// Lấy quantity trong cookie
										Long quatity = Long.parseLong(cookie.getValue());
										product.setQuatity(quatity);
										
										// Cập nhật nó vào db
										//ProductDAO pddao = new ProductDAO();
										//pddao.update(product);
										
										long tong1product = quatity* product.getPrice();
										
										tongcart += tong1product;
										products.add(product);
									}
									
								}
								
							}
						}
						
					}
					
					// Lấy mảng cookie.
					//request.setAttribute("quatityproducts", storequatity);
		 			request.setAttribute("sumcart", tongcart);
					request.setAttribute("products", products);
				}
				url = "/cart.jsp";
				getServletContext()
		        .getRequestDispatcher(url)
		        .forward(request, response);
		     
		     
		}
		
			
		// Thêm vào giỏ hàng
		
		if(action.equals("addproduct"))
		{
			String pdid = request.getParameter("id");
			
			Long idR = Long.parseLong(pdid);
			
			url = "/cart.jsp";
			request.setAttribute("id", idR);
			
			
			// Gio hàng chửa có gì
			if(str_id == "")
			{
				
				String soluong = request.getParameter("quantity");
		        
		        Cookie sl = new Cookie(pdid, soluong);

		        sl.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
		        sl.setPath("/");                      // allow entire app to access it
		        response.addCookie(sl);
				
				// Chưa khởi tạo
				pdid += "@";
		        Cookie ID = new Cookie("id", pdid);

		        ID.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
		        ID.setPath("/");                      // allow entire app to access it
		        response.addCookie(ID);
		        url = "/ProductServlet";
				
			}
			else
			{
				// Nó có đi vào bên trong đây không.
				for (Cookie cookie : arr) {
					if(cookie.getName().equals("id"))
					{
						String id = cookie.getValue();
						
						if(id.contains(pdid)) // Kiểm tra giỏ hàng đã có sản phẩm này hay chưa.
						{
							// Nếu đã có thông báo là sản phẩm đã có trong giỏ hàng rồi.
		
							url = "/ProductServlet";
							break;
						}
						
						id += pdid+"@";
						
						Cookie ID = new Cookie("id", id);

				        ID.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
				        ID.setPath("/");                      // allow entire app to access it
				        response.addCookie(ID);
				        
				        String soluong = request.getParameter("quantity");
				        Cookie sl = new Cookie(pdid, soluong);

				        sl.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
				        sl.setPath("/");                      // allow entire app to access it
				        response.addCookie(sl);
				        
						//cookie.setValue(id);
					}
				}
				url = "/ProductServlet";
			}
		}

		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}
	
	// Xóa phần tử cuối cùng của chuỗi
	private static String removeLastChar(String str) {
	    return str.substring(0, str.length() - 1);
	}

}
