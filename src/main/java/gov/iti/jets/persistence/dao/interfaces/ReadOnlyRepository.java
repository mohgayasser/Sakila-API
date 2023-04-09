package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.models.Page;

import java.util.List;
import java.util.Optional;
public interface ReadOnlyRepository<E,K> extends Repository<E,K>{
    List<E> findAll();

    List<E> findAll(Page page);

    Optional<E> findById(int id) throws validationException;
    Optional<E> findFromContext(K id);

    long count();
    long pages(Page page);
}
