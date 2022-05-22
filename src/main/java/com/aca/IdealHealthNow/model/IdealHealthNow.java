package com.aca.IdealHealthNow.model;

import java.util.ArrayList;
import java.util.List;

public class IdealHealthNow {

	private List<Coach> healthCoaches;
	private String email;
	private String password;
	private String phoneNumber;
	
	
	public List<Coach> getHealthCoaches() {
		return healthCoaches;
	}
	public void setHealthCoaches(List<Coach> healthCoaches) {
		this.healthCoaches = healthCoaches;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
