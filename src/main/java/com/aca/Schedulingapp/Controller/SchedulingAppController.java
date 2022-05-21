package com.aca.Schedulingapp.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("schedulingapp")
public class SchedulingAppController {


	    /**
	     * Method handling HTTP GET requests. The returned object will be sent
	     * to the client as "JSON" media type.
	     *
	     * @return String that will be returned as a JSON response.
	     */
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public String getIt() {
	        return "Got it!";
	    }
	
}
