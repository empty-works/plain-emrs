package com.empty_works.plain_emrs.controller.systems;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create-user")
public class UserCreationController {

	@GetMapping("/show-create-user-form")
	public String showCreateUserForm() {
		
		return "create-user-form";
	}
}
