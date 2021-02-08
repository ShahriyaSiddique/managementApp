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

import com.onik.ManagementApp.models.Client;
import com.onik.ManagementApp.services.ClientService;
import com.onik.ManagementApp.services.CountryService;
import com.onik.ManagementApp.services.StateService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("clients", clientService.getClients());

		return "client";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<Client> findById(Integer id) {
		return clientService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		clientService.deleteById(id);
		return "redirect:/clients";
	}

}
