package com.aca.IdealHealthNow.model;

public class Booking {

	private Integer Id;
	private long bookingDateTime;
	private Patient patient;
	private Appointment appointment;
	
	
	public Booking(Patient patient, Appointment appointment) {
		this.patient = patient;
		this.appointment = appointment;
	}
	
	public long getBookingDateTime() {
		return bookingDateTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public void setBookingDateTime(long bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}
	
	public Integer getBookingId() {
		return Id;
	}
	public void setBookingId(Integer bookingId) {
		this.Id = bookingId;
	}
	
	
	
}
