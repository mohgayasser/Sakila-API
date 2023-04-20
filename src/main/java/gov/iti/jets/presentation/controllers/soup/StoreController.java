package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.films.getStoreDto;
import gov.iti.jets.persistence.dto.store.StoreManagerDto;
import gov.iti.jets.persistence.dto.store.UpdateStoreManagerDto;
import gov.iti.jets.service.StoreService;
import gov.iti.jets.service.util.validations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService (targetNamespace = "StoreWebServer")
public class StoreController {
    @WebMethod
    public getStoreDto getStoreAddressById(@WebParam(name = "id")Integer storeId) throws validationException{
        if (storeId==null||storeId < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            StoreService storeService= new StoreService();
            getStoreDto getStoreDto = storeService.getStoreAdressById(storeId);
            return  getStoreDto;
        }
    }
    @WebMethod
    public StoreManagerDto getStoreManagerById (@WebParam(name = "id") Integer storeId)throws  validationException{
        if (storeId==null||storeId < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            StoreService storeService = new StoreService();
            StoreManagerDto storeManagerDto =storeService.getStoreManagerById(storeId);
            return storeManagerDto;

        }

    }
    @WebMethod
    public boolean updateStoreManager(@WebParam(name = "store") UpdateStoreManagerDto storeManagerDto) throws validationException{
        String valid = ValidFieldsValidator.validate(storeManagerDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
            StoreService storeService = new StoreService();
            boolean result = storeService.updateStoreManager(storeManagerDto);
            return result;
        }
    }

}
