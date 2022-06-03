package com.aca.IdealHealthNow.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
import com.aca.IdealHealthNow.model.Schedule;

public interface ShedulingDao {

	public List<Coach> getCoaches();
	public List<Coach> getCoachById(Integer coachId);
	public List<Coach> getCoachByFullName(String coachFirstName, String coachLastName);
	public Coach createCoach(Coach coach);
	public Coach updateCoach(Coach coach);
	public Coach deleteCoach(Integer coachId);
	public List<Patient> getPatients();
	public List<Patient> getPatientsById(Integer patientId);
	public List<Patient> getPatientsByFullName(String patientFirstName, String patientLastName);
	public Patient createPatient(Patient patient);
	public Patient updatePatient(Patient updatePatient);
	public Patient deletePatient(Integer PatientId);
	public Appointment getAppointmentById(Integer bookingId);
	public Appointment createNewAppointment(Appointment appt);
	public Appointment updateAppointment(Appointment updateAppt);
	public Appointment deleteAppointmentById(Integer apptId);
	public Appointment getPatientsByApptDateRange(long startTime, long endTime);
	
	
}
