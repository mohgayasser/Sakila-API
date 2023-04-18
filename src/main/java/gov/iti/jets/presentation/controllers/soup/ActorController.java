package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.dto.actor.ActorDto;
import gov.iti.jets.persistence.dto.actor.ActorFilmDto;
import gov.iti.jets.presentation.models.UpdateActorDto;
import gov.iti.jets.service.ActorService;
import gov.iti.jets.service.util.customAnnotations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

@WebService(targetNamespace = "ActorWebServer")
public class ActorController {
    @WebMethod
    public ActorDto getActorById(@WebParam(name = "actorId")Integer Id) throws  validationException {
        if(Id==null ||Id<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService = new ActorService();
        ActorDto actorDto = actorService.getActorById(Id);
        return actorDto;
    }
    @WebMethod
    public List<ActorFilmDto> getActorFilms(@WebParam(name = "actorId") Integer actorId) throws validationException {
        if(actorId==null ||actorId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService = new ActorService();
        List<ActorFilmDto> filmDtos = actorService.getActorFilms(actorId);
        return filmDtos;
    }
    @WebMethod
    public boolean addActor(@WebParam(name = "actor") ActorDto newActor) throws validationException {
        String valid = ValidFieldsValidator.validate(newActor);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<ActorDto>> violations = handler.getValidation().validate(newActor);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        ActorService actorService =new ActorService();
        boolean result = actorService.addActor(newActor);
        return result;
    }
    @WebMethod
    public boolean updateActor(@WebParam(name = "newActor") UpdateActorDto actor) throws validationException {
        String valid = ValidFieldsValidator.validate(actor);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<UpdateActorDto>> violations = handler.getValidation().validate(actor);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        ActorService actorService =new ActorService();
        boolean result =actorService.updateActor(actor);
        return result;
    }
    @WebMethod
    public Set<ActorCategoryDto> getActorFilmsCategory(@WebParam(name = "actorId") Integer actorId) throws validationException {
        if(actorId==null ||actorId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService =new ActorService();
        Set<ActorCategoryDto>actorCategoryDtos = actorService.getActorFilmsCategory(actorId);
        return actorCategoryDtos;

    }
    @WebMethod
    public ActorCategoryDto getActorFavCategory(@WebParam(name = "actorId") Integer actorId) throws validationException {
        if(actorId==null ||actorId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService =new ActorService();
        ActorCategoryDto actorCategoryDtos = actorService.getActorFavCategory(actorId);
        return actorCategoryDtos;
    }
}
