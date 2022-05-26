package com.aca.IdealHealthNow.service;

import java.util.List;

import com.aca.IdealHealthNow.Exception.DataNotFoundException;
import com.aca.IdealHealthNow.dao.ShedulingDao;
import com.aca.IdealHealthNow.dao.schedulingDaoImpl;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;

public class SchedulingService {

	ShedulingDao schedulingDao = new schedulingDaoImpl();
	
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

	
	public List<Patient> getPatients() {
		return schedulingDao.getPatients();
	}

	
	public List<Patient> getPatientById() {
		return schedulingDao.getPatientById();
	}

	
	public Patient createPatient() {
		return schedulingDao.createPatient();
	}

	
	public Patient updatePatient() {
		return schedulingDao.updatePatient();
	}


	public Patient deletePatient() {
		return schedulingDao.deletePatient();
	}
	
	
}
