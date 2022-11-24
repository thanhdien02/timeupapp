package com.timeup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timeup.business.Product;
import com.timeup.business.Provider;
import com.timeup.dao.ProductDAO;
import com.timeup.dao.ProviderDAO;


@WebServlet("/ProviderServlet")
public class ProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_provider.jsp";
		
		List<Provider> providers = ProviderDAO.selectProviders();
		
		if(providers != null)
		{
			request.setAttribute("providers", providers);
		}
		
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String url = "/admin_provider.jsp";
		String nameprovider = request.getParameter("nameprovider");
		String numberphone = request.getParameter("numberphone");
		
		String action = request.getParameter("action");
		if(action.equals("addprovider"))
		{
			Provider provider = new Provider();
			
			provider.setNameProvider(nameprovider);
			provider.setNumberPhone(numberphone);
			
			ProviderDAO providerdao = new ProviderDAO();
			
			providerdao.insert(provider);
			
			// Load dữ liệu lên lại
			List<Provider> providers = ProviderDAO.selectProviders();
			
			if(providers != null)
			{
				request.setAttribute("providers", providers);
			}
		}
		if(action.equals("delete"))
		{
			
			String idprvider = request.getParameter("idprovider");
			
			Long id = Long.parseLong(idprvider);
			Provider pvd = ProviderDAO.selectById(id);
			
			if(pvd != null)
			{
				ProviderDAO providerdao = new ProviderDAO();
				providerdao.delete(pvd);
				
				List<Provider> providers = ProviderDAO.selectProviders();
				
				if(providers != null)
				{
					request.setAttribute("providers", providers);
				}
			}
			
			
		}
		
		
		
		getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response); 
	}

}
