package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.service.util.models.Page;

import java.util.List;

public interface rentalDao {
    public List<Rental> getRentByCustomer(Integer customerId, Integer InventoryId);
    public List <Rental> getRentalByCustomerId(Integer customerId, Page page);
}
