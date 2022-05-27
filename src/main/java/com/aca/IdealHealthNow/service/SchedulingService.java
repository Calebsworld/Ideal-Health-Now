package com.aca.IdealHealthNow.service;

import java.util.List;

import com.aca.IdealHealthNow.Exception.DataNotFoundException;
import com.aca.IdealHealthNow.dao.ShedulingDao;
import com.aca.IdealHealthNow.dao.schedulingDaoImpl;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;

public class SchedulingService {

	ShedulingDao schedulingDao = new schedulingDaoImpl();
	
	//coaches
	
	private void validateCoachId(Integer coachId) {
		if (coachId == null || coachId <= 0) {
			throw new DataNotFoundException("Not a valid coachId '" + coachId + "'- coachId must be > 0.");
		}  
		boolean doesExist = false;
		List<Coach> coaches = getCoaches();
		for (Coach coach : coaches) {
			if (coach.getCoachId().equals(coachId)) {
				doesExist = true;
			}
		}
		
		if (!doesExist) {
			throw new DataNotFoundException("Not a valid coachId '" + coachId + "'- coachId does not exist");
		}
		
		
	}
	
	public List<Coach> getCoaches() {
		return schedulingDao.getCoaches();
	}

	
	public List<Coach> getCoachById(Integer coachId) {
		validateCoachId(coachId);
		return schedulingDao.getCoachById(coachId);
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
	
	private void validatePatientId(Integer patientId) {
		if (patientId == null || patientId <= 0) {
			throw new DataNotFoundException("Not a valid patientId '" + patientId + "'- patientId must be > 0.");
		}  
		boolean doesExist = false;
		List<Patient> patients = getPatients();
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				doesExist = true;
			}
		}
		
		if (!doesExist) {
			throw new DataNotFoundException("Not a valid patientId '" + patientId + "'- patientId does not exist");
		}
		
		
	}
	
	public List<Patient> getPatients() {
		return schedulingDao.getPatients();
	}

	
	public List<Patient> getPatientsById(Integer patientId) {
		validatePatientId(patientId);
		return schedulingDao.getPatientsById(patientId);
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
	
	
}
