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

import com.onik.ManagementApp.models.Contact;
import com.onik.ManagementApp.services.ContactService;
import com.onik.ManagementApp.services.CountryService;
import com.onik.ManagementApp.services.StateService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private ContactService contactService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("contacts", contactService.getContacts());

		return "contact";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<Contact> findById(Integer id) {
		return contactService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		contactService.deleteById(id);
		return "redirect:/contacts";
	}

}
