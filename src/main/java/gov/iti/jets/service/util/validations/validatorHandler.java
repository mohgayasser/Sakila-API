package gov.iti.jets.service.util.validations;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import java.util.stream.Collectors;


public class validatorHandler {
    ValidatorFactory factory ;
    public validatorHandler(){

    }
    public Validator getValidation(){
        if(factory ==null){
            factory = Validation.buildDefaultValidatorFactory();
        }
     
        return factory.getValidator();
    }
    public  <T> String getErrorMessage(Set<ConstraintViolation<T>> violations) {
        return violations.stream().map(e -> e.getMessage()).collect(Collectors.joining("; "));
    }   
}
