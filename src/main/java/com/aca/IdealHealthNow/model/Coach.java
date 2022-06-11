package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;
import java.util.List;

public class Coach extends Person {
	
	private Integer Id;
	private LocalDateTime UpdateDateTime;
	private LocalDateTime CreateDateTime;
	
	public Integer getCoachId() {
		return Id;
	}
	public void setCoachId(Integer coachId) {
		this.Id = coachId;
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
