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

import com.onik.ManagementApp.models.VehicleStatus;
import com.onik.ManagementApp.services.VehicleStatusService;

@Controller
@RequestMapping("/vehiclestatuses")
public class VehicleStatusController {
	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
		return "vehicleStatus";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(Integer id) {
		return vehicleStatusService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleStatusService.deleteById(id);
		return "redirect:/vehiclestatuses";
	}
}
