package gov.iti.jets.persistence.dao.interfaces;

import java.util.List;

public interface Repository<E, K>{
    E create (E e);

    E find(K id);

    E findFromContext(K id);

    List<E> findAll();

    E update(E e);

    boolean remove(E e);

}
