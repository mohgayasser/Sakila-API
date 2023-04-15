package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.inventoryDao;
import gov.iti.jets.persistence.entity.Inventory;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class InventoryImpl extends RepositoryImpl<Inventory,Integer> implements inventoryDao  {
    public InventoryImpl(){
        super(Inventory.class);
    }
    @Override
    public List<Inventory> getAllInventories(Integer filmId, Integer storeId) {
        Query query = _entityManager.createQuery("From Inventory I where I.film.Id = :filmId and I.store.Id = :storeId");
        query.setParameter("filmId",filmId);
        query.setParameter("storeId",storeId);
        List<Inventory> inventories = (List<Inventory>) query.getResultList();

        return  inventories;
    }

    @Override
    public List<Inventory> getInventoryIdByFilmId(Integer filmId) {
        String sqlQuery = " from Inventory I where I.film.id= :id ";
        Query query = _entityManager.createQuery(sqlQuery);
        query.setParameter("id",filmId);
        List<Inventory> result = (List<Inventory>)query.getResultList();
        return result;
    }


}
