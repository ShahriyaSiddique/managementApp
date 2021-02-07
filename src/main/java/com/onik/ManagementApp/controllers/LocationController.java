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

import com.onik.ManagementApp.models.Location;
import com.onik.ManagementApp.services.CountryService;
import com.onik.ManagementApp.services.LocationService;
import com.onik.ManagementApp.services.StateService;

@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private LocationService locationService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());

		return "location";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<Location> findById(Integer id) {
		return locationService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		locationService.deleteById(id);
		return "redirect:/locations";
	}

}