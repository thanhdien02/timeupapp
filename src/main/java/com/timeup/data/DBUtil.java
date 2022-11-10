package com.timeup.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT_NAME = "timeupWeb";
    static {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    public static EntityManager getEmFactory() {
        return emf.createEntityManager();
    }
}
