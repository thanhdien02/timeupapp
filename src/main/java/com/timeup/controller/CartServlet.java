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

import org.apache.tomcat.util.http.ServerCookie;

import com.timeup.data.CookieUtil;
import com.timeup.business.Product;
import com.timeup.dao.ProductDAO;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/admin.jsp";
		Cookie []arr = request.getCookies();
		List<Product> products = new ArrayList<>();
		
		String pdid = CookieUtil.getCookieValue(arr, "id");
		
		if(!pdid.equals(""))
		{
			
			// Xóa dấu phẩy cuối chuỗi id
			String idl = removeLastChar(pdid);
			
			String listid[] = pdid.split("@");
			for (String string : listid) {
				
				// Tìm sản phẩm qua id
				Long longid = Long.parseLong(string);
				Product product = ProductDAO.selectById(longid);
				products.add(product);
			}
			url = "/cart.jsp";
			request.setAttribute("products", products);
		}
		url = "/cart.jsp";
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	        url = "/cart.jsp";
	        getServletContext()
	        .getRequestDispatcher(url)
	        .forward(request, response);
		}
		
		
		String pdid = request.getParameter("id");
		
		Long idR = Long.parseLong(pdid);
		
		url = "/cart.jsp";
		request.setAttribute("id", idR);
		if(str_id == "")
		{
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
					id += pdid+"@";
					
					Cookie ID = new Cookie("id", id);

			        ID.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
			        ID.setPath("/");                      // allow entire app to access it
			        response.addCookie(ID);
					//cookie.setValue(id);
				}
			}
			url = "/ProductServlet";
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
