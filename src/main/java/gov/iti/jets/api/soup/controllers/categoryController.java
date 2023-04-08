package gov.iti.jets.api.soup.controllers;

import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.service.category.addCategoryService;
import gov.iti.jets.util.exceptions.validationException;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class categoryController {
    @WebMethod
    public getCategoryDto addCategory(getCategoryDto getCategoryDto) throws validationException{

        addCategoryService addCategoryService =new addCategoryService();
        getCategoryDto dto =  addCategoryService.addCategory(getCategoryDto);
        return dto;

    }
}
