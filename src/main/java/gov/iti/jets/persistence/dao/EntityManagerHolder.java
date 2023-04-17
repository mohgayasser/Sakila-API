package gov.iti.jets.persistence.dao;

import jakarta.persistence.EntityManager;

public class EntityManagerHolder {
    private static final ThreadLocal<EntityManager> entityManagerHolder = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        return entityManagerHolder.get();
    }

    public static void setEntityManager(EntityManager entityManager) {
        entityManagerHolder.set(entityManager);
    }

    public static void removeEntityManager() {
        entityManagerHolder.remove();
    }
}
