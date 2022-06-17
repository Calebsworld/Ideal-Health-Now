package com.aca.IdealHealthNow.Controller;


import java.util.List;

import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
import com.aca.IdealHealthNow.model.Product;
import com.aca.IdealHealthNow.service.IdealHealthNowService;

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
public class IdealHealthNowController {

	private IdealHealthNowService service = new IdealHealthNowService();
	
		@Path("/coaches")
	    @GET
	    public List<Coach> getCoaches() {
	        return service.getCoaches();
	    }
	   
		@Path("coaches/{coachIdValue}")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		public List<Coach> getCoachById (@PathParam ("coachIdValue") Integer id) {
			return service.getCoachById(id);
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
	    public Coach deleteCoach(@PathParam ("coachIdValue") Integer id) {
	    	return service.deleteCoach(id);
	    }
	    
	    @Path("/patients")
	    @GET 
	    public List<Patient> getPatients() {
	    	return service.getPatients();		
	    }
	
	    @Path("/patients/{patientIdValue}")
	    @GET
	    public List<Patient> getPatientsById(@PathParam ("patientIdValue") Integer id) {
	    	return service.getPatientsById(id);
	    }
	    
	    @Path("/patients/patient")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Patient> getPatientsByFullName(
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
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Patient deletePatient(@PathParam ("patientIdValue") Integer id) {
	    	return service.deletePatient(id);
	    }
	    
	    @Path("appointments/{apptIdValue}")
	    @GET 
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Appointment getAppointmentById(@PathParam ("apptIdValue") Integer id) {
	    	return service.getAppointmentById(id);
	    }
	    
	    @Path("/appointments")
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Appointment createAppointment(Appointment appointment) {
	    	return service.createAppointment(appointment);
	    }
	    
	    @Path ("/appointments")
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Appointment updateAppointment(Appointment appointment) {
	    	return service.updateAppointment(appointment);
	    }
	    
	    @Path("/appointments/{apptIdValue}") 
	    @DELETE
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Appointment deleteAppointmentById(@PathParam ("apptIdValue") Integer id) {
	    	return service.deleteAppointmentById(id);
	    }
	   
	    @Path("/products")
	    @GET
	    public List<Product> getAllProducts() {
	    	return service.getAllProducts();
	    }
		
	    @Path("/products/id/{productIdValue}")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Product> getProductById(@PathParam ("productIdValue") Integer id) {
			return service.getProductById(id);
		}
	    
	    @Path("/products/productname")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
		public List<Product> getProductByName(@QueryParam ("productNameValue") String name) {
			return service.getProductByName(name);
		}

	    @Path("/products/category")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		public List<Product> getProductsByCategory(@QueryParam ("categoryValue") String category) {
			return service.getProductsByCategory(category);
		}

		@Path("/products")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Product addProduct(Product product) {
			return service.addProduct(product);
		}

		@Path("/products/id/{productIdValue}")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		public Product removeProductById(@PathParam ("productIdValue") Integer id) {
			return service.removeProductById(id);
		}
	    
	    
	 
	   
	    
	    
	    
	    
	    
	    
	    
}
