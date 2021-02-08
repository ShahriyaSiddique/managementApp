package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleMovement;
import com.onik.ManagementApp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;

	public List<VehicleMovement> getVehicleMovements() {
		return vehicleMovementRepository.findAll();
	}

	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementRepository.findById(id);
	}

	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}

	public void deleteById(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
}
