package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;


public class Appointment {

	private Integer apptId;
	private AppointmentType apptName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private long duration;

	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Integer getApptId() {
		return apptId;
	}
	public void setApptId(Integer apptId) {
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
