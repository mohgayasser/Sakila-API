package gov.iti.jets;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.mysql.cj.log.Log;

import gov.iti.jets.persistence.dao.categoryImpl;
import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.dto.categories.CategoryWIthFilmsDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.service.mapper.categories.CategoryMapper;
import gov.iti.jets.service.mapper.categories.CategoryWithFilmsMapper;
import gov.iti.jets.service.validations.validatorHandler;

public class Main {
    public static void main(String[] args) {
        categoryImpl categoryImpl = new categoryImpl();
        Category category = categoryImpl.find(1);
        CategoryWIthFilmsDto carDto = CategoryWithFilmsMapper.INSTANCE.categoryToCategoryDto( category );
        CategoryDto categoryDto = CategoryMapper.INSTANCE.categoryToCategoryDto( category );
        System.out.println(carDto);
        System.out.println(categoryDto);
        System.out.println(categoryImpl.find(1).getName());

    }
    
}
