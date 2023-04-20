package gov.iti.jets.presentation.controllers.rest;

import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.presentation.models.AddCategoryDto;
import gov.iti.jets.presentation.models.CategorywithoutFilmsDto;
import gov.iti.jets.presentation.models.Link;
import gov.iti.jets.presentation.models.getCategoryByIdDTo;
import gov.iti.jets.service.CategoryService;
import gov.iti.jets.service.util.validations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Path("categories")
public class CategoryRequests {
    @GET
    @Path("{id}/films")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryByIdWithFilms (@PathParam("id")Integer Id)  {
        if (Id==null||Id < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            CategoryService addCategoryService = new CategoryService();
            getCategoryDto getCategoryDto = addCategoryService.getCategoryById(Id);
            return Response.ok(getCategoryDto).build();
        }
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id")Integer Id,@Context UriInfo uriInfo)  {
        if (Id==null||Id < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
             CategoryService addCategoryService = new CategoryService();
             CategorywithoutFilmsDto  category= addCategoryService.getCategoryByIdWithoutFilms(Id);
            Link link =new Link(uriInfo.getAbsolutePathBuilder().toString(),"self");
             getCategoryByIdDTo getCategoryDto = new getCategoryByIdDTo();
             getCategoryDto.addLink(link,uriInfo);
             getCategoryDto.setCategorywithoutFilmsDto(category);
            return Response.ok(getCategoryDto).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(CategorywithoutFilmsDto categorywithoutFilmsDto) {
        String valid = ValidFieldsValidator.validate(categorywithoutFilmsDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
            CategoryService categoryService =new CategoryService();
            boolean result = categoryService.updateCategory(categorywithoutFilmsDto);
            return Response.ok(result).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCategory(AddCategoryDto getCategoryDto,@Context UriInfo uriInfo){
        String valid = ValidFieldsValidator.validate(getCategoryDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
            CategoryService addCategoryService = new CategoryService();
            Integer dto = addCategoryService.addCategory(getCategoryDto);
            URL url= null;
            try {
                url = new URL(uriInfo.getAbsolutePath()+"/"+dto.toString());
                return Response.created(url.toURI()).build();
            } catch (MalformedURLException | URISyntaxException e) {
                return Response.ok(dto).build();
            }
        }
    }
}
