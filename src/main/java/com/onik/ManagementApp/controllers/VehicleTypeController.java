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

import com.onik.ManagementApp.models.VehicleType;
import com.onik.ManagementApp.services.VehicleTypeService;

@Controller
@RequestMapping("/vehicletypes")
public class VehicleTypeController {
	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());

		return "vehicleType";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleType> findById(Integer id) {
		return vehicleTypeService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleTypeService.deleteById(id);
		return "redirect:/vehicleTypes";
	}
}
