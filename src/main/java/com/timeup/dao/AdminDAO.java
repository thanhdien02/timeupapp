package com.timeup.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.timeup.business.Admin;
import com.timeup.data.DBUtil;

public class AdminDAO extends AbstractDAO<Admin>{
	
	public AdminDAO()
	{
		super(Admin.class);
	}
	
    public static Admin selectByName(String nameLogin, String passWord) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM Admin u " +
                "WHERE u.nameLogin = :nameLogin AND u.passWord = :passWord";
        TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
        q.setParameter("nameLogin", nameLogin);
        q.setParameter("passWord", passWord);
        try {
        	Admin admin = q.getSingleResult();
            return admin;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}
