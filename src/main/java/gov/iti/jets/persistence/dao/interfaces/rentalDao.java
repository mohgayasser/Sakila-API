package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Rental;

import java.util.List;

public interface rentalDao {
    public List<Rental> getRentByCustomer(Integer customerId, Integer InventoryId);
}
