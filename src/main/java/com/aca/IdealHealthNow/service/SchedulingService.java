package com.aca.IdealHealthNow.service;

import java.util.List;

import com.aca.IdealHealthNow.dao.ShedulingDao;
import com.aca.IdealHealthNow.dao.schedulingDaoImpl;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;

public class SchedulingService {

	ShedulingDao schedulingDao = new schedulingDaoImpl();
	
	public List<Coach> getCoaches() {
		return schedulingDao.getCoaches();
	}

	
	public Coach getCoachById() {
		return schedulingDao.getCoachById();
	}

	
	public Coach createCoach(Coach coach) {
		return schedulingDao.createCoach(coach);
	 
	}

	
	public Coach updateCoach() {
		return schedulingDao.updateCoach();
	}

	
	public Coach deleteCoach() {
		return schedulingDao.deleteCoach();
	}

	
	public List<Patient> getPatients() {
		return schedulingDao.getPatients();
	}

	
	public Patient getPatientById() {
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
