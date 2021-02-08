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

import com.onik.ManagementApp.models.VehicleHire;
import com.onik.ManagementApp.services.ClientService;
import com.onik.ManagementApp.services.LocationService;
import com.onik.ManagementApp.services.VehicleHireService;
import com.onik.ManagementApp.services.VehicleService;

@Controller
@RequestMapping("/vehiclehires")
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("vehicleHire", vehicleHireService.getVehicleHires());

		return "vehicleHire";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(Integer id) {
		return vehicleHireService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleHireService.deleteById(id);
		return "redirect:/vehiclehire";
	}

}
