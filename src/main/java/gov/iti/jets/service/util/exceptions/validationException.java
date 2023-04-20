package gov.iti.jets.service.util.exceptions;

public class validationException extends RuntimeException{
    public validationException(String errorMsg){
        super(errorMsg);
    }
}
