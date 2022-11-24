package com.timeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.timeup.business.Product;
import com.timeup.business.User;
import com.timeup.data.DBUtil;



public class UserDAO {
	
	private static final long serialVersionUID = 1L;
    
	private static final EntityManagerFactory emFactoryObj;
	private static final String PERSISTENCE_UNIT_NAME = "timeupWeb";	

	static {
		emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	// This Method Is Used To Retrieve The 'EntityManager' Object
	public static EntityManager getEntityManager() {
		return emFactoryObj.createEntityManager();
	}

    public static User selectById(Long userId) {
        EntityManager em = DBUtil.getEmFactory();
        String qString = "SELECT u FROM User u " +
                "WHERE u.userId = :userId";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("userId", userId);
        try {
        	User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
	
    public static void insert(User user)
    
    {
        EntityManager em = getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static User selectUser(String email) {
        EntityManager em = getEntityManager();
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

    public static boolean emailExists(String email) {
        User u = selectUser(email);   
        return u != null;
    }
    
    public static List<User> selectUsers() {
        EntityManager em = getEntityManager();
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
