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

import com.onik.ManagementApp.models.Employee;
import com.onik.ManagementApp.services.CountryService;
import com.onik.ManagementApp.services.EmployeeService;
import com.onik.ManagementApp.services.EmployeeTypeService;
import com.onik.ManagementApp.services.JobTitleService;
import com.onik.ManagementApp.services.StateService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("employees", employeeService.getEmployees());

		return "employee";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<Employee> findById(Integer id) {
		return employeeService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		employeeService.deleteById(id);
		return "redirect:/employees";
	}

}
