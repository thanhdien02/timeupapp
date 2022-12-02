package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.timeup.business.Address;
import com.timeup.business.Product;
import com.timeup.business.Product_category;
import com.timeup.data.DBUtil;

public class AddressDAO  extends AbstractDAO<Address>{
	
	public AddressDAO()
	{
		super(Address.class);
	}
    public static List<Address> selectAddresss() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Address u";
        TypedQuery<Address> q = em.createQuery(qString, Address.class);

        List<Address> addresss;
        try {
        	addresss = q.getResultList();
            if (addresss == null || addresss.isEmpty())
            {
            	addresss = null;
            	return addresss;
            }

        } finally {
            em.close();
        }
        return addresss;
    }
}
