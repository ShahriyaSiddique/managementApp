package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleType;
import com.onik.ManagementApp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}

	public Optional<VehicleType> findById(Integer id) {
		return vehicleTypeRepository.findById(id);
	}

	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	public void deleteById(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}

}
