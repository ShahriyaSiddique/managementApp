package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleHire;
import com.onik.ManagementApp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;

	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
	}

	public Optional<VehicleHire> findById(Integer id) {
		return vehicleHireRepository.findById(id);
	}

	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}

	public void deleteById(Integer id) {
		vehicleHireRepository.deleteById(id);
	}
}
