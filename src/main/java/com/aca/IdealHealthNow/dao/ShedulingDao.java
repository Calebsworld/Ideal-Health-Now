package com.aca.IdealHealthNow.dao;

import java.util.List;

import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;

public interface ShedulingDao {

	public List<Coach> getCoaches();
	public Coach getCoachById();
	public Coach createCoach(Coach coach);
	public Coach updateCoach();
	public Coach deleteCoach();
	public List<Patient> getPatients();
	public Patient getPatientById();
	public Patient createPatient();
	public Patient updatePatient();
	public Patient deletePatient();
}
