package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.timeup.business.Product_category;
import com.timeup.business.Product_image;
import com.timeup.data.DBUtil;

public class Product_imageDAO  extends AbstractDAO<Product_image> {
	
	public Product_imageDAO()
	{
		super(Product_image.class);
	}
	public static List<Product_image> selectProducts_images() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Product_image u";
        TypedQuery<Product_image> q = em.createQuery(qString, Product_image.class);

        List<Product_image> product_images;
        try {
        	product_images = q.getResultList();
            if (product_images == null || product_images.isEmpty())
            	product_images = null;
        } finally {
            em.close();
        }
        return product_images;
    }
}