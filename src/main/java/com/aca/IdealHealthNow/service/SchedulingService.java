package com.aca.IdealHealthNow.service;

import java.util.List;

import com.aca.IdealHealthNow.Exception.DataNotFoundException;
import com.aca.IdealHealthNow.dao.ShedulingDao;
import com.aca.IdealHealthNow.dao.schedulingDaoImpl;
import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;

public class SchedulingService {

	ShedulingDao schedulingDao = new schedulingDaoImpl();
	
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
		return schedulingDao.getCoaches();
	}

	
	public List<Coach> getCoachById(Integer id) {
		validateCoachId(id);
		return schedulingDao.getCoachById(id);
	}

	public List<Coach> getCoachByFullName(String coachFirstName, String coachLastName) {
		return schedulingDao.getCoachByFullName(coachFirstName, coachLastName);
	}
	
	public Coach createCoach(Coach coach) {
		return schedulingDao.createCoach(coach);
	 
	}

	
	public Coach updateCoach(Coach updateCoach) {
		return schedulingDao.updateCoach(updateCoach);
	}

	
	public Coach deleteCoach(Integer coachId) {
		return schedulingDao.deleteCoach(coachId);
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
		return schedulingDao.getPatients();
	}

	
	public List<Patient> getPatientsById(Integer id) {
		validatePatientId(id);
		return schedulingDao.getPatientsById(id);
	}

	
	public Patient createPatient(Patient patient) {
		return schedulingDao.createPatient(patient);
	}

	
	public Patient updatePatient(Patient updatePatient) {
		return schedulingDao.updatePatient(updatePatient);
	}


	public Patient deletePatient(Integer patientId) {
		return schedulingDao.deletePatient(patientId);
	}

	public List<Patient> getPatientsByFullName(String patientFirstName, String patientLastName) {
		return schedulingDao.getPatientsByFullName(patientFirstName, patientLastName);
	}

	// Appointments
	
	public Appointment getAppointmentById(Integer id) {
		return schedulingDao.getAppointmentById(id);
	}

	public Appointment createNewAppointment(Appointment appt) {
		return schedulingDao.createNewAppointment(appt);
	}

	public Appointment updateAppointment(Appointment appt) {
		return schedulingDao.updateAppointment(appt);
	}

	public Appointment deleteAppointmentById(Integer id) {
		return schedulingDao.deleteAppointmentById(id);
	}



	
	
	
	
}
