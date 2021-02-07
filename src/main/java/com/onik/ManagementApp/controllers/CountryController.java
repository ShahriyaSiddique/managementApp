package com.onik.ManagementApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onik.ManagementApp.models.Country;
import com.onik.ManagementApp.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public String getCountries(Model model) {

		List<Country> countryList = countryService.getCountries();

		model.addAttribute("countries", countryList);
		return "country";
	}

	// Add Country
	@PostMapping("/countries/addnew")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping("/countries/findById")
	@ResponseBody
	public Optional<Country> findById(int id) {
		return countryService.findById(id);

	}

	@RequestMapping(value = "/countries/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		countryService.delete(id);
		return "redirect:/countries";
	}

}
