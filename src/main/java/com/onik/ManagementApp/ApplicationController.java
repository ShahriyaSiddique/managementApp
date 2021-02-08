package com.onik.ManagementApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/index")
	public String showHome() {
		return "index";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

}
