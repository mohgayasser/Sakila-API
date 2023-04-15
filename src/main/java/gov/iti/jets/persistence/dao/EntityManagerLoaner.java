package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.Transaction;
import gov.iti.jets.service.util.models.Page;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Map;

public class EntityManagerLoaner {
    private EntityManagerFactory entityManagerFactory = null;
    public EntityManagerLoaner(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    }


    public <T> T execute(Transaction<T> operations, String Query , Map<String,Object> map){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            T result = (T)operations.singleResult(Query, map);
            transaction.commit();
            return result;
        }catch (RuntimeException e){
            transaction.rollback();
            throw e;
        }finally {
            entityManager.close();
        }
    }
    public <T> List<T> executeList(Transaction<T> operations, String Query , Map<String,Object> map, Page page){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            List<T> result = (List<T>)operations.listResult(Query, map,page);
            transaction.commit();
            return result;
        }catch (RuntimeException e){
            transaction.rollback();
            throw e;
        }finally {
            entityManager.close();
        }
    }


}
