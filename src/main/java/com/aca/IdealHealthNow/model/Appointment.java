package com.aca.IdealHealthNow.model;

public class Appointment {

	private Integer Id;
	private Coach coach;
	private AppointmentType appointmentType;
	private DayOfWeek appointmentDayOfWeek;
	private long appointmentStartTime;
	private long appointmentEndTime;
	private long duration;
	private boolean isScheduled;
	

	public Appointment(Coach coach, AppointmentType appointmentType, DayOfWeek dayOfWeek, long startTime) {
		this.coach = coach;
		this.appointmentType = appointmentType;
		this.appointmentDayOfWeek = dayOfWeek;
		this.appointmentStartTime = startTime;
		initializeDuration(appointmentType);
		intializeEndTime(this.appointmentStartTime, this.duration);
	}
	
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
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
	
	public Integer getAppointmentId() {
		return Id;
	}
	public void setApptId(Integer apptId) {
		this.Id = apptId;
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

	public DayOfWeek getAppointmentDayOfWeek() {
		return appointmentDayOfWeek;
	}

	public void setAppointmentDayOfWeek(DayOfWeek appointmentDayOfWeek) {
		this.appointmentDayOfWeek = appointmentDayOfWeek;
	}
	
	public long getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(long appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}
	
	private void intializeEndTime(long startTime, long duration) {
		this.appointmentEndTime = startTime + duration;
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
	
	
}
