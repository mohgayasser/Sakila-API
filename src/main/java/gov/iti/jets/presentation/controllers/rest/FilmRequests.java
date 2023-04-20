package gov.iti.jets.presentation.controllers.rest;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.persistence.dto.films.getFilmListDto;
import gov.iti.jets.presentation.models.*;
import gov.iti.jets.presentation.models.Link;
import gov.iti.jets.service.film.RentFilmService;
import gov.iti.jets.service.film.ReturnFilmService;
import gov.iti.jets.service.film.filmService;
import gov.iti.jets.service.film.insertFilmService;
import gov.iti.jets.service.util.validations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Set;

@Path("films")
public class FilmRequests {
    @GET
    @Path("/getFilmName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getfilmByName(@QueryParam("name") String filmName, @QueryParam("start")Integer start, @QueryParam("limit")Integer limit) throws validationException {
        if(filmName==null||filmName.equals("")){
            throw new validationException("enter film titer for searching");
        }if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number  must be at least 1");
        }
        Page page = new Page(start-1,limit);
        filmService getFilmsService =new filmService();
        List<getFilmDto> getFilmDtoList =  getFilmsService.getFilmByName(filmName,page);
        GenericEntity entity = new GenericEntity<List<getFilmDto>>(getFilmDtoList){};
        return Response.ok(entity).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmById(@PathParam("id") int filmId,@Context UriInfo uriInfo) {
        if(filmId<1){
            throw new validationException("you need to enter a valid Id ex:starting from 1");
        }
        filmService getFilmService =new filmService();
        getFilmDto filmDto =getFilmService.getFilmById(filmId);
        GetFilmByIdDTO getFilmByIdDTO =new GetFilmByIdDTO();
        Link link =new Link(uriInfo.getAbsolutePathBuilder().toString(),"self");
        getFilmByIdDTO.setFilmDto(filmDto);
        getFilmByIdDTO.addLink(link,uriInfo);
        return  Response.ok(getFilmByIdDTO).build();
    }
    @GET
    @Path("/getAllFilms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmList(@QueryParam("start") int start, @QueryParam("limit") int limit)  {

        if (limit<1){
            throw new validationException("the page Size of objects must be at least 1");
        }if (start<1){
            throw new validationException("the page number must be at least 1");
        }
        Page page= new Page(start-1,limit);
        filmService getFilmService = new filmService();
        List<getFilmListDto> getFilmListDto =getFilmService.getFilmsFromFilmListView(page);
        GenericEntity entity = new GenericEntity<List<getFilmListDto>>(getFilmListDto){};
        return Response.ok(entity).build();


    }
    @POST
    @Path("/newFilm")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertFilm( OperationalFilmDto filmDto,@Context UriInfo uriInfo)  {

        validatorHandler handler = new validatorHandler();
        Set<ConstraintViolation<OperationalFilmDto>> violations = handler.getValidation().validate(filmDto);
        if(violations.size() >0){
            String msgs=handler.getErrorMessage(violations);
            throw new validationException(msgs);
        }
        insertFilmService insertFilmService = new insertFilmService();
        Integer result = insertFilmService.insertFilm(filmDto);
        URL url= null;
        try {
            url = new URL(uriInfo.getAbsolutePath()+"/"+result.toString());
            return Response.created(url.toURI()).build();
        } catch (MalformedURLException |URISyntaxException e) {
            return Response.ok(result).build();
        }
    }
    @GET
    @Path("{id}/checkExistence")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkFilmExistance(@PathParam("id") int id)  {
        Boolean result = null;
        if(id<0){
            throw new validationException("You need to enter valid id which for ex starting from 1");
        }
        filmService check =new filmService();
        result = check.isFilmInStock(id);
        return Response.ok(result).build();
    }
    @GET
    @Path("{id}/getFilmRenter")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Set<CustomerDto> getFilmRenter(@PathParam ("id") int id){
        if(id<0){
            throw new validationException("You need to enter valid id which for ex starting from 1");
        }
        filmService getFilmRenterService =new filmService();
        Set<CustomerDto> customerDto = getFilmRenterService.FilmRenter(id);
        if(customerDto !=null){
            return  customerDto;

        }
        else {
            throw new validationException("this film isn't renting to any customer recently");

        }
    }
    @POST
    @Path("rentFilm/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response rentFilm( RentFilmDto rentFilmDto) {

        //RentFilmDto rentFilmDto = new RentFilmDto(customerId,storeId,staffId,filmId,copies);
        String valid = ValidFieldsValidator.validate(rentFilmDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        RentFilmService rentFilmService = new RentFilmService();
        Integer result = rentFilmService.rentFilm(rentFilmDto);

        return Response.ok(result).build();
    }
    @POST
    @Path("returnFilm/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnFilm( ReturnFilmDto returnFilmDto ) {
        String valid = ValidFieldsValidator.validate(returnFilmDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }
        ReturnFilmService returnFilmService = new ReturnFilmService();
        boolean result = returnFilmService.returnFilm(returnFilmDto);

        return Response.ok(result).build();
    }
    @GET
    @Path("getQuantity")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmQuantityInStock(@QueryParam("id") Integer filmId,@QueryParam("store") Integer storeId)  {
        if(filmId<0){
            throw new validationException("You need to enter valid filmId which for ex starting from 1");
        }
        if(storeId<0){
            throw new validationException("You need to enter valid storeId which for ex starting from 1");
        }
        filmService film =new filmService();
        Integer Quantity = film.getFilmQuantity(filmId,storeId);
        return  Response.ok(Quantity).build();
    }
}
