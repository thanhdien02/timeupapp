package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.timeup.business.Product;
import com.timeup.business.Product_specification;
import com.timeup.business.User;
import com.timeup.data.DBUtil;

public class ProductDAO  extends AbstractDAO<Product> {
	
	public ProductDAO()
	{
		super(Product.class);
	}
    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Product u";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> products;
        try {
        	products = q.getResultList();
            if (products == null || products.isEmpty())
            {
            	products = null;
            	return products;
            }

        } finally {
            em.close();
        }
        return products;
    }
    
    public static List<Product> selectProductsByNameCate(String namecate) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Product u";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> products;
        try {
        	products = q.getResultList();
        	// Lấy được hết product sau đó
        	// Từ tên kiếm id của cate 
        	// Từ id => tìm ra list product của nó.
            if (products == null || products.isEmpty())
            {
            	products = null;
            	return products;
            }

        } finally {
            em.close();
        }
        return products;
    }
    
    public static Product selectOneByName(String nameProduct, Long price) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM Product u " +
                "WHERE u.nameProduct = :nameProduct AND u.price = :price";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("nameProduct", nameProduct);
        q.setParameter("price", price);
        try {
        	Product product = q.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static Product selectById(Long productId) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM Product u " +
                "WHERE u.productId = :productId";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("productId", productId);
        try {
        	Product product = q.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
