package com.aca.IdealHealthNow.model;

import java.util.ArrayList;
import java.util.List;

public class IdealHealthNow {

	private List<Coach> coaches;
	private List<Patient> patients;
	private List<Product> products;
	private String email;
	private String phoneNumber;
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Coach> getCoaches() {
		return coaches;
	}
	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
