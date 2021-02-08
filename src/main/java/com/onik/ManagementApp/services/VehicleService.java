package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Vehicle;
import com.onik.ManagementApp.repositories.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}

	public Optional<Vehicle> findById(Integer id) {
		return vehicleRepository.findById(id);
	}

	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public void deleteById(Integer id) {
		vehicleRepository.deleteById(id);
	}

}
