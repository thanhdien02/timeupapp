package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.timeup.business.Product_category;
import com.timeup.business.User;
import com.timeup.data.DBUtil;

public class Product_categoryDAO  extends AbstractDAO<Product_category> {
	
	public Product_categoryDAO()
	{
		super(Product_category.class);
	}
    public static List<Product_category> selectProducts_categorys() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Product_category u";
        TypedQuery<Product_category> q = em.createQuery(qString, Product_category.class);

        List<Product_category> products_category;
        try {
        	products_category = q.getResultList();
            if (products_category == null || products_category.isEmpty())
            	products_category = null;
        } finally {
            em.close();
        }
        return products_category;
    }
    public static Product_category selectOneByName(String nameCategory) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM Product_category u " +
                "WHERE u.nameCategory = :nameCategory";
        TypedQuery<Product_category> q = em.createQuery(qString, Product_category.class);
        q.setParameter("nameCategory", nameCategory);
        try {
        	Product_category product_category = q.getSingleResult();
            return product_category;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}