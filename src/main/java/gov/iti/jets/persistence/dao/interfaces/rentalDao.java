package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface rentalDao {
    public List<Rental> getRentByCustomer(EntityManager entityManager,Integer customerId, Integer InventoryId) throws validationException;
    public List <Rental> getRentalByCustomerId(EntityManager entityManager,Integer customerId, Page page) throws validationException;

}
