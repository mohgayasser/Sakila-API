package gov.iti.jets.presentation.controllers.rest;

import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.dto.actor.ActorDto;
import gov.iti.jets.persistence.dto.actor.ActorFilmDto;
import gov.iti.jets.presentation.models.Link;
import gov.iti.jets.presentation.models.UpdateActorDto;
import gov.iti.jets.service.ActorService;
import gov.iti.jets.service.util.validations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import gov.iti.jets.presentation.models.getActorByIdDTo;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Set;

@Path("actors")
public class ActorRequest {
    @GET
    @Path("{id}/getCategories")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getActorFilmsCategory(@PathParam("id") Integer actorId)  {

        if(actorId==null ||actorId<1){

            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService =new ActorService();
        Set<ActorCategoryDto>actorCategoryDtos = actorService.getActorFilmsCategory(actorId);
        GenericEntity entity = new GenericEntity<Set<ActorCategoryDto>>(actorCategoryDtos){};

        return Response.ok(entity).build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateActor( UpdateActorDto actor) {
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
        return Response.ok(result).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addActor( ActorDto newActor,@Context UriInfo uriInfo)  {
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
        Integer result = actorService.addActor(newActor);
        URL url= null;
        try {
            url = new URL(uriInfo.getAbsolutePath()+"/"+result.toString());
            return Response.created(url.toURI()).build();
        } catch (MalformedURLException | URISyntaxException e) {
            return Response.ok(result).build();
        }
    }
    @GET
    @Path("{id}/getFilms")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getActorFilms(@PathParam("id") Integer actorId)  {
        if(actorId==null ||actorId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService = new ActorService();
        List<ActorFilmDto> filmDtos = actorService.getActorFilms(actorId);
        GenericEntity entity = new GenericEntity<List<ActorFilmDto>>(filmDtos){};
        return Response.ok(entity).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("id")Integer Id,@Context UriInfo uriInfo)  {
        if(Id==null ||Id<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        ActorService actorService = new ActorService();
        ActorDto actorDto = actorService.getActorById(Id);
        gov.iti.jets.presentation.models.Link link =new Link(uriInfo.getAbsolutePathBuilder().toString(),"self");
        getActorByIdDTo getActorByIdDTo = new getActorByIdDTo();
        getActorByIdDTo.setActorDto(actorDto);
        getActorByIdDTo.addLink(link,uriInfo,Id);
        return Response.ok(getActorByIdDTo).build();
    }

}
