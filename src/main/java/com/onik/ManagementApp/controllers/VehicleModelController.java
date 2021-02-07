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

import com.onik.ManagementApp.models.VehicleModel;
import com.onik.ManagementApp.services.VehicleModelService;

@Controller
@RequestMapping("/vehiclemodels")
public class VehicleModelController {
	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());

		return "vehicleModel";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(Integer id) {
		return vehicleModelService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		vehicleModelService.deleteById(id);
		return "redirect:/vehicleModels";
	}

}
