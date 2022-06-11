package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;

public class Patient extends Person{

	private Integer Id;
	private String emailAddress;
	private String phoneNumber;
	private LocalDateTime updateDateTime;
	private LocalDateTime createDateTime;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	public Integer getPatientId() {
		return Id;
	}
	public void setPatientId(Integer patientId) {
		this.Id = patientId;
	}
	
	
	
	
	
}
