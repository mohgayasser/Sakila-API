package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.rentalDao;
import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class rentalImpl  implements rentalDao {
    EntityManagerLoaner entityManagerLoaner;
    public rentalImpl(){
        entityManagerLoaner = new EntityManagerLoaner();

    }

    @Override
    public List<Rental> getRentByCustomer(Integer customerId, Integer InventoryId) throws validationException {
        String sqlQuery = " from Rental R where R.inventory.id= :inventoryId and R.customer.id = :customerId ";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("inventoryId",InventoryId);
        map.put("customerId",customerId);
        List<Rental> result = entityManagerLoaner.executeList(new TransactionImpl<>(Rental.class),sqlQuery,map,null);
        return result;
    }

    @Override
    public List<Rental> getRentalByCustomerId(Integer customerId, Page page) throws validationException {
        String sqlQuery = " from Rental R where R.customer.id = :customerId ";
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("customerId",customerId);
        List<Rental> result = entityManagerLoaner.executeList(new TransactionImpl<>(Rental.class),sqlQuery,map,page);
        return result;
    }


}
