package gov.iti.jets.api.soup.controllers;

import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.service.category.addCategoryService;
import gov.iti.jets.util.exceptions.validationException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class categoryController {
    @WebMethod
    public  CategoryDto addCategory(CategoryDto categoryDto) throws validationException{

        addCategoryService addCategoryService =new addCategoryService();
        CategoryDto dto =  addCategoryService.addCategory(categoryDto);
        return dto;

    }
}
