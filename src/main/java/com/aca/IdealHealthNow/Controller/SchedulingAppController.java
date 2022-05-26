package com.aca.IdealHealthNow.Controller;

import java.util.List;

import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.service.SchedulingService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Home")
@Produces(MediaType.APPLICATION_JSON)
public class SchedulingAppController {

	private SchedulingService service = new SchedulingService();
	
		@Path("/coaches")
	    @GET
	    public List<Coach> getCoaches() {
	        return service.getCoaches();
	    }
	   
		@GET
		@Path("coaches/{coachIdValue}")
		public List<Coach> getCoachById (@PathParam ("coachIdValue") Integer coachId) {
			return service.getCoachById(coachId);
		}
		
		
	    @POST 
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Coach createCoach(Coach coach) {
	    	System.out.println(coach);
	    	return service.createCoach(coach);
	    }
	    
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Coach updateCoach(Coach updateCoach) {
	    	System.out.println(updateCoach);
	    	return service.updateCoach(updateCoach);
	    }
	    
	    @DELETE
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("coaches/{coachIdValue}")
	    public Coach deleteCoach(@PathParam ("coachIdValue") Integer coachId) {
	    	return service.deleteCoach(coachId);
	    }
	    
	
}
