package com.empty_works.plain_emrs.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmrsUser {

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;
	public EmrsUser() {
		
	}
	
	
}
