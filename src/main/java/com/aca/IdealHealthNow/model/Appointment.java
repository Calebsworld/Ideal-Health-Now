package com.aca.IdealHealthNow.model;

public class Appointment {

	private Integer apptId;
	private Integer coachId;
	private AppointmentType appointmentType;
	private DayOfWeek dayOfWeek;
	private long startTime;
	private long endTime;
	private long duration;
	private boolean isScheduled;
	

	public Appointment(Integer coachId, AppointmentType appointmentType, DayOfWeek dayOfWeek, long startTime) {
		this.coachId = coachId;
		this.appointmentType = appointmentType;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		initializeDuration(appointmentType);
		intializeEndTime(this.startTime, this.duration);
	}
	
	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	
	public boolean isScheduled() {
		return isScheduled;
	}
	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public Integer getApptId() {
		return apptId;
	}
	public void setApptId(Integer apptId) {
		this.apptId = apptId;
	}
	public AppointmentType getApptName() {
		return appointmentType;
	}
	public void setApptName(AppointmentType apptName) {
		this.appointmentType = apptName;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	private void initializeDuration(AppointmentType appointmentType) {
		
		if (AppointmentType.NEW_START.equals(appointmentType)) {
			this.duration = 0;
		}
		
		if (AppointmentType.RESTART.equals(appointmentType)) {
			this.duration = 0;
		}
		
		if (AppointmentType.HEALTH_COACHING.equals(appointmentType)) {
			this.duration = 0;
		}
		
		if (AppointmentType.WEIGH_IN.equals(appointmentType)) {
			this.duration = 0;
		}
	}
	
	private void intializeEndTime(long startTime, long duration) {
		this.endTime = startTime + duration;
	}
	
}
