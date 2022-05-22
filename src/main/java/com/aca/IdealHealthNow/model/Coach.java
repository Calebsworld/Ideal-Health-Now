package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;
import java.util.List;

public class Coach {

	@Override
	public String toString() {
		return "Coach [coachId: " + coachId + ", firstName: " + firstName + ", lastName=" + lastName + "]";
	}
	private Integer coachId;
	private String firstName;
	private String lastName;
	private LocalDateTime UpdateDateTime;
	private LocalDateTime CreateDateTime;
		
	public Integer getCoachId() {
		return coachId;
	}
	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
