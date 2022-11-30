package com.timeup.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.timeup.business.Order_detail;
import com.timeup.data.DBUtil;

public class OrderdetailDAO extends AbstractDAO<Order_detail>{
	public OrderdetailDAO()
	{
		super(Order_detail.class);
	}
	
	public static List<Order_detail> selectOrderdetails() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Order_detail u";
        TypedQuery<Order_detail> q = em.createQuery(qString, Order_detail.class);

        List<Order_detail> order_details;
        try {
        	order_details = q.getResultList();
            if (order_details == null || order_details.isEmpty())
            {
            	order_details = null;
            	return order_details;
            }

        } finally {
            em.close();
        }
        return order_details;
    }
}
