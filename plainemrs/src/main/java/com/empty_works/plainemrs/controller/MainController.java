package com.empty_works.plainemrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String showHome() {
		
		return "main";
	}
	
	// Add request mapping for systems
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}

	// Add request mapping for medical staff
	@GetMapping("/medical-staff")
	public String showMedicalStaff() {
		
		return "medicalStaff";
	}

	// Add request mapping for allied staff
	@GetMapping("/allied-staff")
	public String showAlliedStaff() {
		
		return "alliedStaff";
	}

	// Add request mapping for non-employees
	@GetMapping("/non-employees")
	public String showNonEmployees() {
		
		return "nonEmployees";
	}
}
