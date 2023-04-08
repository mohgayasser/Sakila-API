package gov.iti.jets.service.category;

import java.util.Set;

import javax.validation.ConstraintViolation;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.util.exceptions.validationException;
import gov.iti.jets.util.mapper.CategoryMapper;
import gov.iti.jets.util.validations.validatorHandler;


public class addCategoryService {
    public getCategoryDto addCategory(getCategoryDto getCategoryDto) throws validationException {

        Category addedCategory = null;

        RepositoryImpl<Category,Integer> repositoryImpl =new RepositoryImpl<>(Category.class);

        Category category = CategoryMapper.INSTANCE.categoryDtoToCategory(getCategoryDto);

        validatorHandler handler = new validatorHandler();

        Set<ConstraintViolation<getCategoryDto>> violations = handler.getValidation().validate(getCategoryDto);

        if(violations.size() >0){
            String msgs=handler.<getCategoryDto>getErrorMessage(violations);
            throw new validationException(msgs);
        }


        try{
            addedCategory =  repositoryImpl.create(category);

            getCategoryDto.setId(addedCategory.getId());

            return getCategoryDto;
        }catch (Exception exception){ // what is the sql exception
            throw new validationException("Data Base Error");
        }
    }


}