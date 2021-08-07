package com.empty_works.plain_emrs.user;

import org.springframework.format.annotation.DateTimeFormat;
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
	private String givenName;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String middleName;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String city;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String state;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String country;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String phoneNumber;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;

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

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
