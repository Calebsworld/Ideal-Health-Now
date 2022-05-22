package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;

public class Patient {

	private int patientId;
	private String name;
	private String emailAddress;
	private String PhoneNumber;
	private String email;
	private String phoneNumber;
	private LocalDateTime UpdateDateTime;
	private LocalDateTime CreateDateTime;
	
	
	
	public String getFullName() {
		return name;
	}
	public void setFullName(String fullName) {
		this.name = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
}
