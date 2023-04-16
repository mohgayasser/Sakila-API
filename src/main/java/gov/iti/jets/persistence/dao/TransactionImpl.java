package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.Transaction;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TransactionImpl<T> implements Transaction<T>   {
    EntityManager entityManager;
    private Class<T> type;
    public TransactionImpl(Class<T> type){
        this.type = type;
        entityManager =EntityHandler.getEntityManager();
    }
    @Override
    public T singleResult(String query, Map<String,Object>parameters) {
        Query result =  entityManager.createQuery(query);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            result.setParameter(entry.getKey(),entry.getValue());
        }
        result.setMaxResults(1);
        T finalResult = (T)result.getSingleResult();
        return finalResult ;
    }

    @Override
    public T functions(String Query, Map<String, Object> parameters) {
        Query result =  entityManager.createNativeQuery(Query);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            result.setParameter(entry.getKey(),entry.getValue());
        }
        result.setMaxResults(1);
        T finalResult = (T)result.getSingleResult();
        return finalResult ;
    }

    @Override
    public List<T> listResult(String query, Map<String,Object> parameters, Page page) {

        Query result =  entityManager.createQuery(query);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            result.setParameter(entry.getKey(),entry.getValue());
        }
        if(page !=null){
            result.setFirstResult(page.getPageNumber() * page.getPageSize());
            result.setMaxResults(page.getPageSize());
        }
        List<T> finalResult = result.getResultList();
        return finalResult;
    }
//
//    @Override
//    public List<T> findAll() {
//        List<T> list = (List<T>) entityManager.createQuery("FROM " + type.getName() + " ",type).getResultList();
//
//        return list;
//    }
//
//    @Override
//    public List<T> findAll(Page page) {
//
//        Query selectQuery = entityManager.createQuery("From "+type.getName());
//        selectQuery.setFirstResult(page.getPageNumber()*page.getPageSize());
//        selectQuery.setMaxResults(page.getPageNumber());
//        List<T> list = selectQuery.getResultList();
//
//        return list;
//    }

    @Override
    public T findById(int id) throws validationException {
        T entity = entityManager.find(type, id);
        return entity;

    }
//
//    @Override
//    public Long count() {
//        long count= (long) entityManager.createQuery("SELECT COUNT(t) FROM " + type.getName() + "t ")
//                .getSingleResult();
//        return count;
//    }
//
//    @Override
//    public long pages(Page page) {
//        long count= (long) entityManager.createQuery("SELECT COUNT(t) FROM " + type.getName() + "t ")
//                .getSingleResult();
//        int lastPageNumber = (int) (Math.ceil(count / page.getPageSize()));
//
//        return lastPageNumber;
//    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        T entity =entityManager.merge(t);
        return entity;
    }

    @Override
    public Boolean remove(T t) {
        entityManager.remove(t);
        return true;
    }
}
