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

import com.onik.ManagementApp.models.InvoiceStatus;
import com.onik.ManagementApp.services.InvoiceStatusService;

@Controller
@RequestMapping("/invoicestatuses")
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());
		return "invoiceStatus";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(Integer id) {
		return invoiceStatusService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatuses";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatuses";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		invoiceStatusService.deleteById(id);
		return "redirect:/invoicestatuses";
	}

}
