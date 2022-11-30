package com.timeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Order;
import com.timeup.dao.OrderDAO;


@WebServlet("/OrderSelfServlet")
public class OrderSelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String url = "/order_self.jsp";

		List<Order> orders = OrderDAO.selectOrders();
		
		// Từ cookie lấy ra user từ user mới lấy ra các đơn hàng của user đó nữa.
		
		Cookie []arr = request.getCookies();
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
		
		List<Order> listtorder = new ArrayList<Order>();
		
		if(orders != null)
		{
			for (Order order : orders) {
				if(order.getUser().getNameLogin().equals(username))
				{
					listtorder.add(order);
				}
			}
			
			request.setAttribute("orders", listtorder);
		}
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
