package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;
import java.util.List;

public class Coach extends Person {
	
	private LocalDateTime UpdateDateTime;
	private LocalDateTime CreateDateTime;
	private WorkWeek workWeek;
	
	
	public WorkWeek getWorkWeek() {
		return workWeek;
	}
	public void setWorkWeek(WorkWeek workWeek) {
		this.workWeek = workWeek;
	}
	
	public LocalDateTime getUpdateDateTime() {
		return UpdateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		UpdateDateTime = updateDateTime;
	}
	public LocalDateTime getCreateDateTime() {
		return CreateDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		CreateDateTime = createDateTime;
	}
	
	
	
	
	
	
	
	
	
	
}
