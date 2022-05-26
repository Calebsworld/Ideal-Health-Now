package com.aca.IdealHealthNow.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestError {

	private int errorCode;
	private String message;
	private String documentation;

	
	public RequestError() {
		
	}
	
	public RequestError(int errorCode, String message, String documentation) {
		this.errorCode = errorCode;
		this.message = message;
		this.documentation = documentation;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
	
	
}
