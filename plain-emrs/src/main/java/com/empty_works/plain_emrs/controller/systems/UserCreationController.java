package com.empty_works.plain_emrs.controller.systems;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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
		
		// Form validation
		if(theBindingResult.hasErrors()) {
			
			theModel.addAttribute("emrsUser", new EmrsUser());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");
			
			logger.warning("User name/password can not be empty.");

			return "create-user-confirmation";
		}
		
		// check the database if user already exists
		boolean userExists = doesUserExist(userName);
		
		if (userExists) {
			theModel.addAttribute("crmUser", new EmrsUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			
			return "create-user-confirmation";
		}
		
		// encrypt the password
        String encodedPassword = passwordEncoder.encode(theEmrsUser.getPassword());

        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;
                 
		// give user default role of "employee"
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_AUTHORIZED");

        // create user object (from Spring Security framework)
        User tempUser = new User(userName, encodedPassword, authorities);

        // save user in the database
        userDetailsManager.createUser(tempUser);		
		
        logger.info("Successfully created user: " + userName);
        
        return "create-user-confirmation";
	}

	private boolean doesUserExist(String userName) {
		
		logger.info("Checking if user exists: " + userName);
		
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		
		logger.info("User: " + userName + ", exists: " + exists);
		
		return exists;
	}
}
