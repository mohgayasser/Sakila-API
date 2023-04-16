package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.inventoryDao;
import gov.iti.jets.persistence.entity.Country;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.Query;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InventoryImpl implements inventoryDao  {
    EntityManagerLoaner entityManagerLoaner ;
    public InventoryImpl(){
        entityManagerLoaner =new EntityManagerLoaner();
    }
    @Override
    public List<Inventory> getAllInventories(Integer filmId, Integer storeId) throws validationException {
        String query="From Inventory I where I.film.Id = :filmId and I.store.Id = :storeId";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("filmId",filmId);
        map.put("storeId",storeId);
        List<Inventory> inventories = entityManagerLoaner.executeList(new TransactionImpl<>(Inventory.class),query,map,null);

        return  inventories;
    }

    @Override
    public List<Inventory> getInventoryIdByFilmId(Integer filmId) throws validationException {
        String sqlQuery = " from Inventory I where I.film.id= :id ";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("id",filmId);
        List<Inventory> result =entityManagerLoaner.executeList(new TransactionImpl<>(Inventory.class),sqlQuery,map,null);
        return result;
    }


}
