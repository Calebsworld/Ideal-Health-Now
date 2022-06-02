package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;

public class WorkDay {

	private String dayOfWeek;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private LocalDateTime breakTime;
	private Schedule schedule;

	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
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
	public LocalDateTime getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(LocalDateTime breakTime) {
		this.breakTime = breakTime;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
}
