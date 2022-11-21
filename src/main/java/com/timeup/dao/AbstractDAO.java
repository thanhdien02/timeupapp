package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.timeup.business.User;
import com.timeup.data.DBUtil;

public abstract class AbstractDAO<T> {
private static final long serialVersionUID = 1L;
    
	private Class<T> entityClass;
	
	public AbstractDAO(Class<T> cls)
	{
		this.entityClass = cls;
	}
	
	
    public void insert(T entity)
    
    {
        EntityManager em = DBUtil.getEmFactory();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void update(T entity) {
        EntityManager em = DBUtil.getEmFactory();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void delete(T entity) {
        EntityManager em = DBUtil.getEmFactory();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(entity));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public User selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM User u " +
                "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public boolean emailExists(String email) {
        User u = selectUser(email);   
        return u != null;
    }
    
    public List<User> selectUsers() {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u from User u";
        TypedQuery<User> q = em.createQuery(qString, User.class);

        List<User> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty())
                users = null;
        } finally {
            em.close();
        }
        return users;
    }
}
