package com.empty_works.plain_emrs.user;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmrsUser {

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String emailAddress;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private Date createdOn;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private boolean enabled;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String authority;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String patientId;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String nonpatientId;

	public EmrsUser() {
		
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getNonpatientId() {
		return nonpatientId;
	}

	public void setNonpatientId(String nonpatientId) {
		this.nonpatientId = nonpatientId;
	}
}
