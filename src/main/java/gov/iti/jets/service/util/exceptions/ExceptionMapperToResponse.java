package gov.iti.jets.service.util.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import  gov.iti.jets.service.util.exceptions.ErrorMsg;
@Provider

public class ExceptionMapperToResponse   implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {

            ErrorMsg errorMessage = new ErrorMsg(ex.getMessage(), 404, "probably wrong Passing data ");
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(errorMessage).build();

    }
}