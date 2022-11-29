package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.timeup.business.Order;
import com.timeup.data.DBUtil;


public class OrderDAO extends AbstractDAO<Order>{
	public OrderDAO()
	{
		super(Order.class);
	}
	
	public static List<Order> selectOrders() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Order u";
        TypedQuery<Order> q = em.createQuery(qString, Order.class);

        List<Order> orders;
        try {
        	orders = q.getResultList();
            if (orders == null || orders.isEmpty())
            {
            	orders = null;
            	return orders;
            }

        } finally {
            em.close();
        }
        return orders;
    }
//    public static Order selectOneByName(String note_custumer, Long priceSum, Long userId) {
//        EntityManager em = DBUtil.getEmFactory();
//        String qString = "SELECT u FROM Order u " +
//                "WHERE u.note_custumer = :note_custumer AND u.priceSum = :priceSum AND u.userId = :userId";
//        TypedQuery<Order> q = em.createQuery(qString, Order.class);
//        q.setParameter("note_custumer", note_custumer);
//        q.setParameter("priceSum", priceSum);
//        try {
//        	Order order = q.getSingleResult();
//            return order;
//        } catch (NoResultException e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
}
