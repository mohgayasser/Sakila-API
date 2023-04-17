package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;

public interface Transaction<T> extends Repository<T,Integer>{


    T singleResult(EntityManager entityManager, String query, Map<String, Object> parameters);



    T functions(EntityManager entityManager, String Query, Map<String, Object> parameters);



    List<T> listResult(EntityManager entityManager, String query, Map<String, Object> parameters, Page page);


}
