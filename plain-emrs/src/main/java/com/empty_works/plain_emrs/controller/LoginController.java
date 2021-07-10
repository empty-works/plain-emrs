package com.empty_works.plain_emrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/show-login-page")
	public String showLoginPage() {
		
		return "plain-login";
	}
	
	// Add request mapping for access deni
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
