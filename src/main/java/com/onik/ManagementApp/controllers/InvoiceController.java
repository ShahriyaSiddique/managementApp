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

import com.onik.ManagementApp.models.Invoice;
import com.onik.ManagementApp.services.ClientService;
import com.onik.ManagementApp.services.InvoiceService;
import com.onik.ManagementApp.services.InvoiceStatusService;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("")
	public String findAll(Model model) {

		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());
		model.addAttribute("invoices", invoiceService.getInvoices());

		return "invoice";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<Invoice> findById(Integer id) {
		return invoiceService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		invoiceService.deleteById(id);
		return "redirect:/invoices";
	}

}
