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

import com.onik.ManagementApp.models.VehicleMovement;
import com.onik.ManagementApp.services.LocationService;
import com.onik.ManagementApp.services.VehicleMovementService;
import com.onik.ManagementApp.services.VehicleService;

@Controller
@RequestMapping("/vehiclemovements")
public class VehicleMovementController {
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleMovementService vehicleMovementService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());

		return "vehicleMovement";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleMovementService.deleteById(id);
		return "redirect:/vehiclemovements";
	}

}
