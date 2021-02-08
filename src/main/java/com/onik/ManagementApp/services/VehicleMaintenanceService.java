package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleMaintenance;
import com.onik.ManagementApp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;

	public List<VehicleMaintenance> getVehicleMaintenances() {
		return vehicleMaintenanceRepository.findAll();
	}

	public Optional<VehicleMaintenance> findById(Integer id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}

	public void deleteById(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
