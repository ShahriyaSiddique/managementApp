package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Supplier;
import com.onik.ManagementApp.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}

	public Optional<Supplier> findById(Integer id) {
		return supplierRepository.findById(id);
	}

	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	public void deleteById(Integer id) {
		supplierRepository.deleteById(id);
	}
}
