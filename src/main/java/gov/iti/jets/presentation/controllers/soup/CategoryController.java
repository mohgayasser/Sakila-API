package gov.iti.jets.presentation.controllers.soup;

import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.presentation.models.AddCategoryDto;
import gov.iti.jets.presentation.models.CategorywithoutFilmsDto;
import gov.iti.jets.service.CategoryService;
import gov.iti.jets.service.util.validations.ValidFieldsValidator;
import gov.iti.jets.service.util.exceptions.validationException;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(targetNamespace = "CategoryWebServer")
public class CategoryController {
    @WebMethod
    public Integer addCategory(@WebParam(name = "category") AddCategoryDto getCategoryDto) throws validationException{
        String valid = ValidFieldsValidator.validate(getCategoryDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
            CategoryService addCategoryService = new CategoryService();
            Integer dto = addCategoryService.addCategory(getCategoryDto);
            return dto;
        }
    }
    @WebMethod
    public getCategoryDto getCategoryById (@WebParam(name = "id") Integer categoryId) throws validationException{
        if (categoryId==null||categoryId < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            CategoryService addCategoryService = new CategoryService();
            getCategoryDto getCategoryDto = addCategoryService.getCategoryById(categoryId);
            return getCategoryDto;
        }
    }
    @WebMethod
    public CategorywithoutFilmsDto getCategoryByIdFilms (@WebParam(name = "id") Integer categoryId) throws validationException{
        if (categoryId==null||categoryId < 0) {
            throw new validationException("you need to enter a valid id");
        } else {
            CategoryService addCategoryService = new CategoryService();
            CategorywithoutFilmsDto category= addCategoryService.getCategoryByIdWithoutFilms(categoryId);
            return category;
        }
    }
    @WebMethod
    public boolean updateCategory(@WebParam(name = "category") CategorywithoutFilmsDto categorywithoutFilmsDto) throws validationException{
        String valid = ValidFieldsValidator.validate(categorywithoutFilmsDto);
        if(valid.length()>0){
            throw new validationException(valid);
        }else {
            CategoryService categoryService =new CategoryService();
            boolean result = categoryService.updateCategory(categorywithoutFilmsDto);
            return result;
        }
    }
}
