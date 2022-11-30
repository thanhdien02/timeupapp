package com.timeup.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Address;
import com.timeup.business.Order;
import com.timeup.business.Order_detail;
import com.timeup.business.Product;
import com.timeup.business.User;
import com.timeup.dao.AddressDAO;
import com.timeup.dao.OrderDAO;
import com.timeup.dao.OrderdetailDAO;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.UserDAO;
import com.timeup.data.CookieUtil;
import com.timeup.data.DeleteCookie;


@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Load lại các product lên check out để thanh toán
		
		String url = "/checkout.jsp";
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
 			
 			// Load address len neu co
			String username = "";
			if(arr != null)
			{
				for (Cookie cookie : arr) {
					if(cookie.getName().equals("username"))
					{
						username = cookie.getValue();
					}

				}
			}
			// Từ tên đăng nhập. Sẽ lấy được user. Trong user sẽ có địa chỉ của user
			
			User user = UserDAO.selectByUserName(username);
			if(user != null)
			{
				
				if(user.getAddress() != null)
				{
					request.setAttribute("user", user);
				}
				
			}
			
			// Lấy mảng cookie.
			//request.setAttribute("quatityproducts", storequatity);
 			request.setAttribute("sumcart", tongcart);
			request.setAttribute("products", products);
		}
		url = "/checkout.jsp";
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_provider.jsp";
		
		String action = request.getParameter("action");
		
		
		if(action.equals("checkout"))
		{
			// Lấy dữ liệu từ address. 
			// Từ user lấy xem có có địa chỉ hay chưa
			
			// Thêm vào address
			String city = request.getParameter("city");
			String dicstrict = request.getParameter("dicstrict");
			String ward = request.getParameter("ward");
			String number_address = request.getParameter("number_addess");
			// update user
			String phone = request.getParameter("phone");
			
			
			
			
			// Update số điện thoại cho user nếu nó chưa có
			
			// Lấy user name từ cookie
			Cookie []arr = request.getCookies();
			String username = "";
			if(arr != null)
			{
				for (Cookie cookie : arr) {
					if(cookie.getName().equals("username"))
					{
						username = cookie.getValue();
						request.setAttribute("username", username);
					}

				}
			}
			
			// Update user phone and full name
			
			UserDAO userdao = new UserDAO();
			User user = UserDAO.selectByUserName(username);
			if(user != null)
			{
				if(user.getNumberPhone() == null)
				{
					user.setNumberPhone(phone);
				}
				if(user.getFullName() == null)
				{
					String fullname = request.getParameter("fullname");
					user.setFullName(fullname);
				}
				// Cập nhật lại
				UserDAO.update(user);
			}
			
			
			
			Address address = new Address();
			
			address.setCiTy(city);
			address.setDicstrict(dicstrict);
			address.setWard(ward);
			address.setNumber_Home(number_address);
			address.setUser(user);
			
			AddressDAO addressdao = new AddressDAO();
			addressdao.insert(address);

			
			// Thêm order

			// thêm vào order
			String order_note = request.getParameter("order_note");
			String priceSum = request.getParameter("priceSum");
			
			OrderDAO orderdao = new OrderDAO();
			Order order = new Order();
			order.setNote_custumer(order_note);
			order.setPriceSum(Long.parseLong(priceSum));
			order.setDateShip(LocalDateTime.now());
			order.setUser(user);
			orderdao.insert(order);
			
			
			
			
			//Lấy cái order vừa thêm vào
			
			//Order orderadddetail = OrderDAO.selectOneByName(order_note, Long.parseLong(priceSum));
			
			// Sau đó đến với order detail
			
			// Lay list product gio hang tu cookie
			
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
					
					if(product != null)
						products.add(product);
					
					
					// Thêm order detail
					OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
					Order_detail order_detail = new Order_detail();
					order_detail.setPrice(product.getPrice());
					order_detail.setProduct(product);
					order_detail.setOrder(order);
					// Lấy số lượng sản phẩm đặt từ cookie giỏ hàng
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
								order_detail.setNumber(quatity);
								break;
							}
							
						}
					}

					orderdetailDAO.insert(order_detail);					
					
					
				}

			}
			url = "/thankyou.jsp";
			// List nó ra
			
		}
		// Xóa cookie của giỏ hàng.
		Cookie []arrcookie = request.getCookies();
		DeleteCookie.deleteOneCookie(request, response, arrcookie, "id");
		
		// Xóa cái cookie lưu quantity của nó.
		
		
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); 
	}
	private static String removeLastChar(String str) {
	    return str.substring(0, str.length() - 1);
	}

}
