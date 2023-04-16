package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.Transaction;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
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

    public <T,R> T executeCRUD(Transaction<T> operations,R value,String Operation) throws validationException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T result;
        try{
            result = switch (Operation) {
                case "find" -> (T) operations.findById((Integer) value);
                case "create" -> (T) operations.create((T)value);
                case "remove" -> (T) operations.remove((T) value);
                case "update" -> (T) operations.update((T) value);
                default -> null;
            };

            transaction.commit();

        }catch (RuntimeException e){
            transaction.rollback();
            throw new validationException("something happened Wrong in the database "+e.getMessage());
        }finally {
            entityManager.close();
        }
        return result;
    }
    public <T> T execute(Transaction<T> operations, String Query , Map<String,Object> map) throws validationException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String search  = "DUAL";
        transaction.begin();
        T result;
        try{

            if ( Query.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {

              result  = (T)operations.functions(Query, map);
            } else {
                result = (T)operations.singleResult(Query, map);
            }

            transaction.commit();

        }catch (RuntimeException e){
            transaction.rollback();
            throw new validationException("something happened Wrong in the database "+e.getMessage());
        }finally {
            entityManager.close();
        }
        return result;
    }
    public <T> List<T> executeList(Transaction<T> operations, String Query , Map<String,Object> map, Page page) throws validationException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<T> result;
        try{
             result = (List<T>)operations.listResult(Query, map,page);
            transaction.commit();

        }catch (RuntimeException e){
            transaction.rollback();
            throw new validationException("something happened Wrong in the database "+e.getMessage());
        }finally {
            entityManager.close();
        }
        return result;
    }


}
