package com.empty_works.plain_emrs.user;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class EmrsUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private Collection<? extends GrantedAuthority> authorities;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String patientId;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String nonpatientId;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private boolean isNonExpired;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private boolean isNonLocked;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private boolean isCredNonExpired;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private boolean isEnabled;

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
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
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
	
	public void setIsNonExpired(boolean isNonExpired) {
		this.isNonExpired = isNonExpired;
	}
	
	public void setIsNonLocked(boolean isNonLocked) {
		this.isNonLocked = isNonLocked;
	}
	
	public void setIsCredNonExpired(boolean isCredNonExpired) {
		this.isCredNonExpired = isCredNonExpired;
	}
	
	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}
