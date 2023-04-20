package gov.iti.jets.presentation.controllers.rest;

import gov.iti.jets.persistence.dto.films.getStoreDto;
import gov.iti.jets.persistence.dto.store.StoreManagerDto;
import gov.iti.jets.persistence.dto.store.UpdateStoreManagerDto;
import gov.iti.jets.service.StoreService;
import gov.iti.jets.service.util.customAnnotations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("stores")
public class StoreRequests {
    @GET
    @Path("{id}/address")
    public Response getStoreAddress(@PathParam("id") Integer Id){
        if(Id==null ||Id<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        StoreService storeService= new StoreService();
        getStoreDto getStoreDto = storeService.getStoreAdressById(Id);
        return Response.ok(getStoreDto).build();
    }
    @GET
    @Path("{id}/manager")
    public Response getStoreManager(@PathParam("id") Integer Id){
        if(Id==null ||Id<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        StoreService storeService= new StoreService();
        StoreManagerDto getStoreDto = storeService.getStoreManagerById(Id);
        return Response.ok(getStoreDto).build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStoreManager(UpdateStoreManagerDto storeManagerDto){
        String valid = ValidFieldsValidator.validate(storeManagerDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
            StoreService storeService = new StoreService();
            boolean result = storeService.updateStoreManager(storeManagerDto);
            return Response.ok(result).build();
        }
    }

}
