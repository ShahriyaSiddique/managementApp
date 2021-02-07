package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleModel;
import com.onik.ManagementApp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}

	public Optional<VehicleModel> findById(Integer id) {
		return vehicleModelRepository.findById(id);
	}

	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	public void deleteById(Integer id) {
		vehicleModelRepository.deleteById(id);
	}

}
