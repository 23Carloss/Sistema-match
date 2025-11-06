package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 * @author brand
 */
public class JpaUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    private JpaUtil() {
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}