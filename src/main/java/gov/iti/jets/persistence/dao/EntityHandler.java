package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;

public class EntityHandler  implements EntityManagerOperations {
    private static EntityManagerFactory entityManagerFactory;
    public EntityHandler() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("sakila") ;
    }
    @Override
    public  EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void closeEntityManager() {
        EntityManager entityManager = EntityManagerHolder.getEntityManager();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("close Entity Manager");
            EntityManagerHolder.removeEntityManager();
        }
    }

    public static CriteriaBuilder getCriteriaBuilder(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
        }
        return entityManagerFactory.getCriteriaBuilder();
    }
}
