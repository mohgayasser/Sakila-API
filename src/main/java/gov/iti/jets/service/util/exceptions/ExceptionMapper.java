package gov.iti.jets.service.util.exceptions;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.hibernate.tool.schema.spi.ExceptionHandler;

public class ExceptionMapper implements ExceptionHandler {

    @Override
    public void handleException(CommandAcceptanceException e) {
        System.out.println(e.getMessage());
    }
}