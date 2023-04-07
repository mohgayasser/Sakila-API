package gov.iti.jets.persistence.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface Repository<E, K>{
    E create (E e);

    E update(E e);

    boolean remove(E e);


}
