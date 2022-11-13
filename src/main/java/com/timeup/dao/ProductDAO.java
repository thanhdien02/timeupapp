package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.timeup.business.Product;
import com.timeup.business.User;
import com.timeup.data.DBUtil;

public class ProductDAO  extends AbstractDAO<Product> {
	
	public ProductDAO()
	{
		super(Product.class);
	}
    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from products u";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> products;
        try {
        	products = q.getResultList();
            if (products == null || products.isEmpty())
            	products = null;
        } finally {
            em.close();
        }
        return products;
    }
}
