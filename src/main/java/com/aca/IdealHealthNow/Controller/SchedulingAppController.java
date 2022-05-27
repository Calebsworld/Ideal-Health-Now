package com.aca.IdealHealthNow.Controller;

import java.util.List;

import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
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
	   
		@Path("coaches/{coachIdValue}")
		@GET
		public List<Coach> getCoachById (@PathParam ("coachIdValue") Integer coachId) {
			return service.getCoachById(coachId);
		}
		
		@Path("/coaches")
	    @POST 
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Coach createCoach(Coach coach) {
	    	System.out.println(coach);
	    	return service.createCoach(coach);
	    }
	    
		@Path("/coaches")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Coach updateCoach(Coach updateCoach) {
	    	System.out.println(updateCoach);
	    	return service.updateCoach(updateCoach);
	    }
		
		@Path("coaches/{coachIdValue}")
	    @DELETE
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Coach deleteCoach(@PathParam ("coachIdValue") Integer coachId) {
	    	return service.deleteCoach(coachId);
	    }
	    
	    @Path("/patients")
	    @GET 
	    public List<Patient> getPatients() {
	    	return service.getPatients();		
	    }
	
	    @Path("/patients/{patientIdValue}")
	    @GET
	    public List<Patient> getPatientsById(@PathParam ("patientIdValue") Integer patientId) {
	    	return service.getPatientsById(patientId);
	    }
	    
	    @Path("/patients")
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Patient createPatient(Patient patient) {
	    	return service.createPatient(patient);
	    }
	    
	    @Path("/patients")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Patient updatePatient(Patient updatePatient) {
	    	return service.updatePatient(updatePatient);
	    }
	    
	    @Path("/patients/{patientIdValue}")
	    @DELETE
	    public Patient deletePatient(@PathParam ("patientIdValue") Integer patientId) {
	    	return service.deletePatient(patientId);
	    }
	    
}
