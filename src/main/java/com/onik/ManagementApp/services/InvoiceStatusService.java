package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.InvoiceStatus;
import com.onik.ManagementApp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;

	public List<InvoiceStatus> getInvoiceStatuses() {
		return invoiceStatusRepository.findAll();
	}

	public Optional<InvoiceStatus> findById(Integer id) {
		return invoiceStatusRepository.findById(id);
	}

	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	public void deleteById(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}

}
