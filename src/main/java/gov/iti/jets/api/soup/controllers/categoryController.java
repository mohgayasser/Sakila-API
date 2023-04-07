package gov.iti.jets.api.soup.controllers;

import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.service.categories.addCategoryService;
import gov.iti.jets.service.exceptions.validations.validationException;
import jakarta.jws.WebService;

@WebService
public class categoryController {

    public static CategoryDto addCategory(CategoryDto categoryDto) throws validationException{

        addCategoryService addCategoryService =new addCategoryService();
        CategoryDto dto =  addCategoryService.addCategory(categoryDto);
        return dto;

    }
}
