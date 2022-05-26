package com.aca.IdealHealthNow.dao;

import java.util.List;

import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;

public interface ShedulingDao {

	public List<Coach> getCoaches();
	public List<Coach> getCoachById(Integer coachId);
	public Coach createCoach(Coach coach);
	public Coach updateCoach(Coach coach);
	public Coach deleteCoach(Integer coachId);
	public List<Patient> getPatients();
	public List<Patient> getPatientById();
	public Patient createPatient();
	public Patient updatePatient();
	public Patient deletePatient();
}
