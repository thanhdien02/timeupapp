package com.timeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Order_detail;
import com.timeup.dao.OrderdetailDAO;

@WebServlet("/OrderdetailServlet")
public class OrderdetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/order_detail.jsp";

		
		String idorder = request.getParameter("idorder");
		Long id = Long.parseLong(idorder);
		
		List<Order_detail> order_details = OrderdetailDAO.selectOrderdetails();
		List<Order_detail> ganorder_detail = new ArrayList<Order_detail>();
		if(order_details != null)
		{
			for (Order_detail order_detail : order_details) {
				if(order_detail.getOrder().getOrderId() == id)
				{
					ganorder_detail.add(order_detail);
				}
				
			}
			request.setAttribute("order_details", ganorder_detail);
		}
		
		String action = request.getParameter("action");
		
		if(action.equals("public"))
		{
			url = "/public_order_detail.jsp";
		}
		else 
		{
			url = "/order_detail.jsp";
		}
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

}
