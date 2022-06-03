package com.aca.IdealHealthNow.Controller;

import java.time.LocalDateTime;
import java.util.List;

import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
import com.aca.IdealHealthNow.model.Schedule;
import com.aca.IdealHealthNow.model.WorkDay;
import com.aca.IdealHealthNow.service.SchedulingService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
		@Consumes(MediaType.APPLICATION_JSON)
		public List<Coach> getCoachById (@PathParam ("coachIdValue") Integer coachId) {
			return service.getCoachById(coachId);
		}
		
		@Path("/coaches/coach")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Coach> getCoachByFullName(
	    		@QueryParam("coachFirstName") String coachFirstName,
	    		@QueryParam("coachLastName") String coachLastName) {
	        return service.getCoachByFullName(coachFirstName, coachLastName);
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
	    
	    @Path("/patients/patient")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Patient> getPatientsByLastName(
	    		@QueryParam("patientFirstName") String patientFirstName,
	    		@QueryParam("patientLastName") String patientLastName) {
	    	return service.getPatientsByFullName(patientFirstName, patientLastName);
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
	    
	    @Path("appointments/{apptIdValue}")
	    @GET 
	    public Appointment getAppointmentById(@PathParam ("apptIdValue") Integer apptId) {
	    	return null;
	    }
	    
	    @Path("/appointments")
	    @POST
	    public Appointment createNewAppointment(Appointment appt) {
	    
	    return null;
	    }
	    
	    @Path ("/appointments")
	    @PUT
	    public Appointment updateAppointment(Appointment appt) {
	    	
	    	return null;
	    }
	    
	    @Path("/appointments/{apptIdValue}") 
	    @DELETE
	    public Appointment deleteAppointmentById(@PathParam ("apptIdValue") Integer apptId) {
	    	
	    	return null;
	    }
	   
	    @Path("/patients/report")
	    @GET
	    public List<Patient> getPatientsByApptDateRange(
	    		@QueryParam ("startDateTimeValue") LocalDateTime startDateTime, 
	    		@QueryParam ("endDateTimeValue") LocalDateTime endDateTime) {
	    	
	    	
	    	return null;
	    }
	    
	    @Path("/coach/schedule")
	    @GET
	    public Schedule getScheduleByCoachWorkDay(Coach coach) {
	    
	    return null;
	    }
	    
	   
	    
	    
	    
	    
	    
	    
	    
}
