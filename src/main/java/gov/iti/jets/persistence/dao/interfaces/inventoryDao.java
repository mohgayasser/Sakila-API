package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.List;

public interface inventoryDao {
    public List<Inventory> getAllInventories(Integer filmId, Integer storeId) throws validationException;

    public List<Inventory> getInventoryIdByFilmId(Integer filmId) throws validationException;
}
