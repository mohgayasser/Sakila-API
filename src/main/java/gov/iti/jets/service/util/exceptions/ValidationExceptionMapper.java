package gov.iti.jets.service.util.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ValidationExceptionMapper implements ExceptionMapper<validationException> {
    @Override
    public Response toResponse(validationException validationException) {
        ErrorMsg errorMessage = new ErrorMsg(validationException.getMessage(), 404, "probably wrong Passing from data");
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(errorMessage).build();


    }
}
