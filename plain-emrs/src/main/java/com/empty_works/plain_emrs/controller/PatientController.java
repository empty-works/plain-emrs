package com.empty_works.plain_emrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empty_works.plain_emrs.entity.Patient;
import com.empty_works.plain_emrs.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Patient> thePatients = patientService.getPatients();
		theModel.addAttribute("patients", thePatients);
		return "list-patients";
	}
	
	@GetMapping("/show-form-for-add")
	public String showFormForAdd(Model theModel) {
		
		Patient thePatient = new Patient();
		theModel.addAttribute(thePatient);
		return "show-form-for-add";
	}
	
	@PostMapping("/save-patient")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		
		patientService.savePatient(thePatient);
		return "redirect:/patient/list";
	}
	
	@GetMapping("/show-form-for-update")
	public String showFormForUpdate(@RequestParam("patientId") int theId, Model theModel) {
	
		Patient thePatient = patientService.getPatient(theId);
		theModel.addAttribute("patient", thePatient);
		return "patient-form";
	}
	
	@GetMapping("/delete")
	public String deletePatient(@RequestParam("patientId") int theId) {
		
		patientService.deletePatient(theId);
		return "redirect:/patient/list";
	}
}
