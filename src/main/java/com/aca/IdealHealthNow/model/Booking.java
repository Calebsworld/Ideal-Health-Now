package com.aca.IdealHealthNow.model;

public class Booking {

	private Integer bookingId;
	private Integer appointmentId;
	private Integer patientId;
	
	public Booking(Integer appointmentId, Integer patientId) {
		this.appointmentId = appointmentId;
		this.patientId = patientId;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getAppointment() {
		return appointmentId;
	}
	public void setAppointment(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatient(Integer patientId) {
		this.patientId = patientId;
	}
	
	
}
