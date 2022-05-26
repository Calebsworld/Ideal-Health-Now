package com.aca.IdealHealthNow.Exception;

import com.aca.IdealHealthNow.model.RequestError;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		RequestError errorMessage = new RequestError(404, ex.getMessage(), "");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

	
	
}
