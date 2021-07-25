package com.empty_works.plain_emrs.person;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmrsPerson {

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String givenName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String streetAddress;

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
	private Date dateOfBirth;
	
	public EmrsPerson() {
		
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
