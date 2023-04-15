package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.entity.Inventory;

import java.util.List;

public interface inventoryDao {
    public List<Inventory> getAllInventories(Integer filmId, Integer storeId);

    public List<Inventory> getInventoryIdByFilmId(Integer filmId);
}
