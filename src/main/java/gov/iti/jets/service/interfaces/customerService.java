package gov.iti.jets.service.interfaces;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.entity.Customer;

public interface customerService {

    RepositoryImpl<Customer, Integer> repo = new RepositoryImpl<>(Customer.class);
}
