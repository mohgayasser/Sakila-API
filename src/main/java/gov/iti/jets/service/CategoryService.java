package gov.iti.jets.service;

import java.util.Set;

import gov.iti.jets.persistence.dao.categoryImpl;
import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.CategoryMapper;
import gov.iti.jets.service.util.validations.validatorHandler;
import jakarta.validation.ConstraintViolation;


public class CategoryService {
    public getCategoryDto addCategory(getCategoryDto getCategoryDto) throws validationException {

        Category addedCategory = null;
        categoryImpl categoryImpl =new categoryImpl();
        Category category = CategoryMapper.INSTANCE.categoryDtoToCategory(getCategoryDto);

        validatorHandler handler = new validatorHandler();

        Set<ConstraintViolation<getCategoryDto>> violations = handler.getValidation().validate(getCategoryDto);

        if(violations.size() >0){
            String msgs=handler.<getCategoryDto>getErrorMessage(violations);
            throw new validationException(msgs);
        }


        try{
            addedCategory = categoryImpl.createCategory(category);

            getCategoryDto.setId(addedCategory.getId());

            return getCategoryDto;
        }catch (Exception exception){ // what is the sql exception
            throw new validationException("Data Base Error");
        }
    }


}