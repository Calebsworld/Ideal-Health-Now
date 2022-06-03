package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;
import java.util.List;

public class WorkWeek {

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
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

	private List<WorkDay> workWeek;

	public List<WorkDay> getWorkWeek() {
		return workWeek;
	}

	public void setWorkWeek(List<WorkDay> workWeek) {
		this.workWeek = workWeek;
	}
	
	
	
}
