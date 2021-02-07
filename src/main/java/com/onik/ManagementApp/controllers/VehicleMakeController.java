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

import com.onik.ManagementApp.models.VehicleMake;
import com.onik.ManagementApp.services.VehicleMakeService;

@Controller
@RequestMapping("/vehiclemakes")
public class VehicleMakeController {
	@Autowired
	private VehicleMakeService vehicleMakeService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());

		return "vehicleMake";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(Integer id) {
		return vehicleMakeService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleMakeService.deleteById(id);
		return "redirect:/vehiclemakes";
	}
}