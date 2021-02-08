package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Invoice;
import com.onik.ManagementApp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}

	public Optional<Invoice> findById(Integer id) {
		return invoiceRepository.findById(id);
	}

	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	public void deleteById(Integer id) {
		invoiceRepository.deleteById(id);
	}
}
