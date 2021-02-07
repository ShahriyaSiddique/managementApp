package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleMake;
import com.onik.ManagementApp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;

	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();
	}

	public Optional<VehicleMake> findById(Integer id) {
		return vehicleMakeRepository.findById(id);
	}

	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

	public void deleteById(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}

}
