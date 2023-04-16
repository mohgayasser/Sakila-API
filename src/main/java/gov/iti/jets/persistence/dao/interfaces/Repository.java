package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.service.util.exceptions.validationException;

public interface Repository<E, K>{
    E create (E e);

    E update(E e);

    Boolean remove(E e);


    E findById(int id) throws validationException;
}
