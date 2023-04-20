package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.EntityManagerLoaner;
import gov.iti.jets.persistence.dao.EntityManagerOperationsProxy;
import gov.iti.jets.persistence.dao.TransactionImpl;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dto.films.getStoreDto;
import gov.iti.jets.persistence.dto.store.StoreManagerDto;
import gov.iti.jets.persistence.dto.store.UpdateStoreManagerDto;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.persistence.entity.Store;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.GetStoreMapper;
import gov.iti.jets.service.util.mapper.StoreManagerMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Optional;

public class StoreService {
    EntityManagerLoaner entityManagerLoaner=new EntityManagerLoaner();
    private final EntityManagerOperations entityManagerOperations;
    public  StoreService(){
        entityManagerOperations= new EntityManagerOperationsProxy();
    }
    public Store getStoreById(EntityManager entityManager,Integer StoreId) throws validationException {

        Optional<Store> store = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Store.class), StoreId, "find"));
        if (store.isPresent()){
            return store.get();
        }
        else {
            throw new validationException("this store Id is wrong.");
        }
    }
    public getStoreDto getStoreAdressById(Integer Id) throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Store store =entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Store.class), Id, "find");
        getStoreDto getStoreDto = GetStoreMapper.INSTANCE.storeTogetStoreDto(store);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return getStoreDto;

    }
    public StoreManagerDto getStoreManagerById(Integer Id) throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Store store =entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Store.class), Id, "find");
        StoreManagerDto getStoreDto = StoreManagerMapper.INSTANCE.storeToStoreManagerDto(store);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return getStoreDto;

    }
    public boolean updateStoreManager(UpdateStoreManagerDto storeManagerDto) throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Store store =entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Store.class), storeManagerDto.getId(), "find");
        Staff manager =entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Staff.class), storeManagerDto.getManagerId(), "find");
       if(manager ==null){
           throw new validationException("this staff member does not exist in our system ");
       }
        if(!manager.getActive()){
            throw new validationException("this staff member no longer work with us ");
        }
        store.setManagerStaff(manager);
        store.setLastUpdate(new Date());
      try {
          Store updatedStor =entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Store.class), store, "update");
      }catch (RuntimeException e){
          throw new validationException("the Manager Can Manage only one store");
      }
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return true;

    }
}
