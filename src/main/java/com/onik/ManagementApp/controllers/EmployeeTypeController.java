package com.onik.ManagementApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onik.ManagementApp.models.EmployeeType;
import com.onik.ManagementApp.services.EmployeeTypeService;

@Controller
@RequestMapping("/employeetypes")
public class EmployeeTypeController {
	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());

		return "employeeType";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(Integer id) {
		return employeeTypeService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		employeeTypeService.deleteById(id);
		return "redirect:/employeetypes";
	}
}
