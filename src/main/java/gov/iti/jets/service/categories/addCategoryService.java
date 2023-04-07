package gov.iti.jets.service.categories;

import java.util.Set;

import javax.validation.ConstraintViolation;

import gov.iti.jets.persistence.dao.RepositoryImpl;
import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.service.exceptions.validations.validationException;
import gov.iti.jets.service.mapper.categories.CategoryMapper;
import gov.iti.jets.service.validations.validatorHandler;

public class addCategoryService {
 public CategoryDto addCategory(CategoryDto categoryDto) throws validationException {
    
    Category addedCategory = null;
    
    RepositoryImpl<Category,Integer> repositoryImpl =new RepositoryImpl<>(Category.class);
    
    Category category = CategoryMapper.INSTANCE.categoryDtoToCategory( categoryDto );

    validatorHandler handler = new validatorHandler();
    
    Set<ConstraintViolation<CategoryDto>> violations = handler.getValidation().validate(categoryDto);
   
    if(violations.size() >0){
      String msgs=handler.<CategoryDto>getErrorMessage(violations);
      throw new validationException(msgs);
    }
   

    try{
    addedCategory =  repositoryImpl.create(category);

    categoryDto.setId(addedCategory.getId());

    return categoryDto;
    }catch (Exception exception){ // what is the sql exception
       throw new validationException("Data Base Error");
    }
 }
    

}
