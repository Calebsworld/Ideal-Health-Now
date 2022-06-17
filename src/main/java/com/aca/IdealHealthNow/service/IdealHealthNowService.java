package com.aca.IdealHealthNow.service;

import java.util.List;

import com.aca.IdealHealthNow.Exception.DataNotFoundException;
import com.aca.IdealHealthNow.dao.IdealHealthNowDao;
import com.aca.IdealHealthNow.dao.IdealHealthNowDaoImpl;
import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
import com.aca.IdealHealthNow.model.Product;

public class IdealHealthNowService {

	IdealHealthNowDao idealHealthNowDao = new IdealHealthNowDaoImpl();
	
	//coaches
	
	private void validateCoachId(Integer id) {
		if (id == null || id <= 0) {
			throw new DataNotFoundException("Not a valid coachId '" + id + "'- coachId must be > 0.");
		}  
		boolean doesExist = false;
		List<Coach> coaches = getCoaches();
		for (Coach coach : coaches) {
			if (coach.getCoachId().equals(id)) {
				doesExist = true;
			}
		}
		if (!doesExist) {
			throw new DataNotFoundException("Not a valid coachId '" + id + "'- coachId does not exist");
		}
	}
	
	public List<Coach> getCoaches() {
		return idealHealthNowDao.getCoaches();
	}

	
	public List<Coach> getCoachById(Integer id) {
		validateCoachId(id);
		return idealHealthNowDao.getCoachById(id);
	}

	public List<Coach> getCoachByFullName(String coachFirstName, String coachLastName) {
		return idealHealthNowDao.getCoachByFullName(coachFirstName, coachLastName);
	}
	
	public Coach createCoach(Coach coach) {
		return idealHealthNowDao.createCoach(coach);
	 
	}

	
	public Coach updateCoach(Coach updateCoach) {
		return idealHealthNowDao.updateCoach(updateCoach);
	}

	
	public Coach deleteCoach(Integer coachId) {
		return idealHealthNowDao.deleteCoach(coachId);
	}

	
	// Patients
	
	private void validatePatientId(Integer id) {
		if (id == null || id <= 0) {
			throw new DataNotFoundException("Not a valid patientId '" + id + "'- patientId must be > 0.");
		}  
		boolean doesExist = false;
		List<Patient> patients = getPatients();
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(id)) {
				doesExist = true;
			}
		}
		
		if (!doesExist) {
			throw new DataNotFoundException("Not a valid patientId '" + id + "'- patientId does not exist");
		}
		
		
	}
	
	public List<Patient> getPatients() {
		return idealHealthNowDao.getPatients();
	}

	
	public List<Patient> getPatientsById(Integer id) {
		validatePatientId(id);
		return idealHealthNowDao.getPatientsById(id);
	}

	
	public Patient createPatient(Patient patient) {
		return idealHealthNowDao.createPatient(patient);
	}

	
	public Patient updatePatient(Patient updatePatient) {
		return idealHealthNowDao.updatePatient(updatePatient);
	}


	public Patient deletePatient(Integer patientId) {
		return idealHealthNowDao.deletePatient(patientId);
	}

	public List<Patient> getPatientsByFullName(String patientFirstName, String patientLastName) {
		return idealHealthNowDao.getPatientsByFullName(patientFirstName, patientLastName);
	}

	// Appointments
	
	public Appointment getAppointmentById(Integer id) {
		return idealHealthNowDao.getAppointmentById(id);
	}

	public Appointment createAppointment(Appointment appt) {
		return idealHealthNowDao.createAppointment(appt);
	}

	public Appointment updateAppointment(Appointment appt) {
		return idealHealthNowDao.updateAppointment(appt);
	}

	public Appointment deleteAppointmentById(Integer id) {
		return idealHealthNowDao.deleteAppointmentById(id);
	}

	public List<Product> getAllProducts() {
		return idealHealthNowDao.getAllProducts();
	}
	
	public List<Product> getProductById(Integer id) {
		return idealHealthNowDao.getProductById(id);
	}

	public List<Product> getProductByName(String name) {
		return idealHealthNowDao.getProductByName(name);
	}

	
	public List<Product> getProductsByCategory(String category) {
		return idealHealthNowDao.getProductsByCategory(category);
	}

	
	public Product addProduct(Product product) {
		return idealHealthNowDao.addProduct(product);
	}

	
	public Product removeProductById(Integer id) {
		return idealHealthNowDao.removeProductById(id);
	}

	public List<Product> getProductsByProductType(String productType) {
		return idealHealthNowDao.getProductsByProductType(productType);
	}



	
	
	
	
}
