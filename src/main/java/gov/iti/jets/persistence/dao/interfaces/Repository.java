package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

public interface Repository<T, K>{
    T findById(K id, EntityManager entityManager) throws validationException;

    T create(T t, EntityManager entityManager);

    T update(T t, EntityManager entityManager);

    Boolean remove(T t, EntityManager entityManager);
}
