package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.rentalDao;
import gov.iti.jets.persistence.entity.Rental;
import jakarta.persistence.Query;

import java.util.List;

public class rentalImpl extends RepositoryImpl<Rental,Integer> implements rentalDao {
    public rentalImpl(){
        super(Rental.class);
    }
    @Override
    public List<Rental> getRentByCustomer(Integer customerId, Integer InventoryId) {
        String sqlQuery = " from Rental R where R.inventory.id= :inventoryId and R.customer.id = :customerId ";
        Query query = _entityManager.createQuery(sqlQuery);
        query.setParameter("inventoryId",InventoryId);
        query.setParameter("customerId",customerId);
        List<Rental> result =  query.getResultList();
        return result;
    }

}
