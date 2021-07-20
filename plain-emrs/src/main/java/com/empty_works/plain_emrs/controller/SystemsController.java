package com.empty_works.plain_emrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemsController {

	@GetMapping("/create-user") 
	public String showCreateUser() {

		return "create-user";
	}
}
