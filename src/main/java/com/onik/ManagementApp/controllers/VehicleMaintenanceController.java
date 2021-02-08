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

import com.onik.ManagementApp.models.VehicleMaintenance;
import com.onik.ManagementApp.services.SupplierService;
import com.onik.ManagementApp.services.VehicleMaintenanceService;
import com.onik.ManagementApp.services.VehicleService;

@Controller
@RequestMapping("/vehiclemaintenances")
public class VehicleMaintenanceController {
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("suppliers", supplierService.getSuppliers());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());

		return "vehicleMaintenance";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(Integer id) {
		return vehicleMaintenanceService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenance";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleMaintenanceService.deleteById(id);
		return "redirect:/vehiclemaintenance";
	}

}
