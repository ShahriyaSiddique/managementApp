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

import com.onik.ManagementApp.models.Vehicle;
import com.onik.ManagementApp.services.EmployeeService;
import com.onik.ManagementApp.services.LocationService;
import com.onik.ManagementApp.services.VehicleMakeService;
import com.onik.ManagementApp.services.VehicleModelService;
import com.onik.ManagementApp.services.VehicleService;
import com.onik.ManagementApp.services.VehicleStatusService;
import com.onik.ManagementApp.services.VehicleTypeService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleModelService vehicleModelService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;

	// Get All Vehicles
	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());

		return "vehicle";
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Optional<Vehicle> findById(Integer id) {
		return vehicleService.findById(id);
	}

	// Add Vehicle
	@PostMapping(value = "/addnew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleService.deleteById(id);
		return "redirect:/vehicles";
	}
}
