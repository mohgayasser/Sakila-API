package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class EntityManagerOperationsProxy implements EntityManagerOperations {

    private final EntityHandler entityManagerOperations;

    public EntityManagerOperationsProxy() {
        this.entityManagerOperations = new EntityHandler();
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerOperations.getEntityManager();
            EntityManagerHolder.setEntityManager(entityManager);
        }
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        return entityManager;
    }

    @Override
    public void closeEntityManager() {
        entityManagerOperations.closeEntityManager();
    }
}