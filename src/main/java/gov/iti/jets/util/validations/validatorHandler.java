package gov.iti.jets.util.validations;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
