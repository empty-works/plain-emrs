package com.empty_works.plainemrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/show-login-page")
	public String showLoginPage() {
		
		return "plain-login";
	}
	
	// Add request mapping for access denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
