package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface inventoryDao {
    public List<Inventory> getAllInventories(EntityManager entityManager,Integer filmId, Integer storeId) throws validationException;

    public List<Inventory> getInventoryIdByFilmId(EntityManager entityManager,Integer filmId) throws validationException;
}
