package com.aca.IdealHealthNow.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
import com.aca.IdealHealthNow.model.Product;
import com.aca.IdealHealthNow.model.Schedule;

public interface IdealHealthNowDao {

	public List<Coach> getCoaches();
	public List<Coach> getCoachById(Integer id);
	public List<Coach> getCoachByFullName(String coachFirstName, String coachLastName);
	public Coach createCoach(Coach coach);
	public Coach updateCoach(Coach coach);
	public Coach deleteCoach(Integer id);
	public List<Patient> getPatients();
	public List<Patient> getPatientsById(Integer id);
	public List<Patient> getPatientsByFullName(String patientFirstName, String patientLastName);
	public Patient createPatient(Patient patient);
	public Patient updatePatient(Patient updatePatient);
	public Patient deletePatient(Integer id);
	public Appointment getAppointmentById(Integer id);
	public Appointment createAppointment(Appointment appointment);
	public Appointment updateAppointment(Appointment updateAppointment);
	public Appointment deleteAppointmentById(Integer id);
	public List<Product> getAllProducts();
	public List<Product> getProductById(Integer id);
	public List<Product> getProductByName(String name);
	public List<Product> getProductsByCategory(String category);
	public Product addProduct(Product product);
	public Product removeProductById(Integer id);
	
	
	
}
