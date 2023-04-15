package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.Transaction;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.service.util.models.Page;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

public class transactionImpl<T> implements Transaction<T>   {
    EntityManager entityManager;
    private Class<T> type;
    public transactionImpl(Class<T> type){
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
}
