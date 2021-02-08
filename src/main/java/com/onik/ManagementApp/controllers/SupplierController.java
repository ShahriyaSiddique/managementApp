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

import com.onik.ManagementApp.models.Supplier;
import com.onik.ManagementApp.services.CountryService;
import com.onik.ManagementApp.services.StateService;
import com.onik.ManagementApp.services.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private SupplierService supplierService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("suppliers", supplierService.getSuppliers());

		return "supplier";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<Supplier> findById(Integer id) {
		return supplierService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		supplierService.deleteById(id);
		return "redirect:/suppliers";
	}

}
