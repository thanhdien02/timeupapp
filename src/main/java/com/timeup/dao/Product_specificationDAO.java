package com.timeup.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.timeup.business.Product;
import com.timeup.business.Product_category;
import com.timeup.business.Product_specification;
import com.timeup.data.DBUtil;

public class Product_specificationDAO extends AbstractDAO<Product_specification> {
	
	public Product_specificationDAO()
	{
		super(Product_specification.class);
	}
	
	 public static Product_specification selectOneByName(String color, String use_time, String origin) {
	        EntityManager em = DBUtil.getEmFactory();
	        String qString = "SELECT u FROM Product_specification u " +
	                "WHERE u.color = :color AND u.use_time = :use_time AND u.origin = :origin";
	        TypedQuery<Product_specification> q = em.createQuery(qString, Product_specification.class);
	        q.setParameter("color", color);
	        q.setParameter("origin", origin);
	        q.setParameter("use_time", use_time);
	        try {
	        	Product_specification product_specification = q.getSingleResult();
	            return product_specification;
	        } catch (NoResultException e) {
	            return null;
	        } finally {
	            em.close();
	        }
	 }
	    public static Product_specification selectById(Long pd_specificationId) {
	        EntityManager em = DBUtil.getEmFactory();
	        String qString = "SELECT u FROM Product_specification u " +
	                "WHERE u.pd_specificationId = :pd_specificationId";
	        TypedQuery<Product_specification> q = em.createQuery(qString, Product_specification.class);
	        q.setParameter("pd_specificationId", pd_specificationId);
	        try {
	        	Product_specification productspecifi = q.getSingleResult();
	            return productspecifi;
	        } catch (NoResultException e) {
	            return null;
	        } finally {
	            em.close();
	        }
	    }
}
