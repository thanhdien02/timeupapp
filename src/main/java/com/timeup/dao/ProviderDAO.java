package com.timeup.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.timeup.business.Product;
import com.timeup.business.Provider;
import com.timeup.data.DBUtil;

public class ProviderDAO extends AbstractDAO<Provider> {

	public ProviderDAO()
	{
		super(Provider.class);
	}
	public static List<Provider> selectProviders() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from Provider u";
        TypedQuery<Provider> q = em.createQuery(qString, Provider.class);

        List<Provider> providers;
        try {
        	providers = q.getResultList();
            if (providers == null || providers.isEmpty())
            {
            	providers = null;
            	return providers;
            }

        } finally {
            em.close();
        }
        return providers;
    }
	
    public static Provider selectById(Long providerId) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM Provider u " +
                "WHERE u.providerId = :providerId";
        TypedQuery<Provider> q = em.createQuery(qString, Provider.class);
        q.setParameter("providerId", providerId);
        try {
        	Provider provider = q.getSingleResult();
            return provider;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
