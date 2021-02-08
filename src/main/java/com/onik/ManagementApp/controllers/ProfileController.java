package com.onik.ManagementApp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onik.ManagementApp.services.EmployeeService;

@Controller
public class ProfileController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/profile")
	private String getProfile(Model model, Principal principal) {

		String un = principal.getName();

		model.addAttribute("employee", employeeService.findByUsername(un));

		return "profile";
	}

}
