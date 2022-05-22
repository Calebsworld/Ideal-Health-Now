package com.aca.IdealHealthNow.model;

import java.time.LocalTime;

public class Appointment {

	private int apptId;
	private AppointmentType apptName;
	private long duration;

	
	public int getApptId() {
		return apptId;
	}
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	public AppointmentType getApptName() {
		return apptName;
	}
	public void setApptName(AppointmentType apptName) {
		this.apptName = apptName;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	
	
}
