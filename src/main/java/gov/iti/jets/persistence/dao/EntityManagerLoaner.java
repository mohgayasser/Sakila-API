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


    public <T,R> T executeCRUD(EntityManager entityManager,Transaction<T> operations,R value,String Operation) throws validationException {

        T result;
        try{
            result = switch (Operation) {
                case "find" -> (T) operations.findById((Integer) value,entityManager);
                case "create" -> (T) operations.create((T)value,entityManager);
                case "remove" -> (T) operations.remove((T) value,entityManager);
                case "update" -> (T) operations.update((T) value,entityManager);
                default -> null;
            };
            System.out.println("result ->"+result);
            //transaction.commit();
            return result;
        }catch (RuntimeException e){
            entityManager.getTransaction().rollback();
            throw new validationException("something happened Wrong in the database "+e.getMessage());
        }

    }
    public <T> T execute(EntityManager entityManager,Transaction<T> operations, String Query , Map<String,Object> map) throws validationException {


        String search  = "DUAL";

        T result;
        try{

            if ( Query.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {

              result  = (T)operations.functions(entityManager,Query, map);
            } else {
                result = (T)operations.singleResult(entityManager,Query, map);
            }
            return result;
        }catch (RuntimeException e){
            entityManager.getTransaction().rollback();
            throw new validationException("something happened Wrong in the database "+e.getMessage());
        }

    }
    public <T> List<T> executeList(EntityManager entityManager,Transaction<T> operations, String Query , Map<String,Object> map, Page page) throws validationException {

        List<T> result;
        try{
             result = (List<T>)operations.listResult(entityManager,Query, map,page);
            return result;
        }catch (RuntimeException e){
            entityManager.getTransaction().rollback();
            throw new validationException("something happened Wrong in the database "+e.getMessage());
        }

    }


}
