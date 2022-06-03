package com.aca.IdealHealthNow.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

	private List<Appointment> appointments = new ArrayList<>();
	
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
	
}
