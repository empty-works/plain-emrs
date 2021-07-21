package com.empty_works.plain_emrs.controller.systems;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empty_works.plain_emrs.user.EmrsUser;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/create-user")
public class UserCreationController {

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	

	@GetMapping("/show-create-user-form")
	public String showCreateUserForm(Model theModel) {
		
		theModel.addAttribute("emrsUser", new EmrsUser());
		
		return "create-user-form";
	}
	
	@PostMapping("/process-user-creation")
	public String processUserCreation(
			@Valid @ModelAttribute("emrsUser") EmrsUser theEmrsUser, 
			BindingResult theBindingResult, 
			Model theModel) {
		
		String userName = theEmrsUser.getUserName();
		logger.info("Processing user creation for: " + userName);
		
		return "create-user-confirmation";
	}
}
