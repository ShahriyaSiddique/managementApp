package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.VehicleStatus;
import com.onik.ManagementApp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository lehicleStatusRepository;

	public List<VehicleStatus> getVehicleStatuses() {
		return lehicleStatusRepository.findAll();
	}

	public Optional<VehicleStatus> findById(Integer id) {
		return lehicleStatusRepository.findById(id);
	}

	public void save(VehicleStatus lehicleStatus) {
		lehicleStatusRepository.save(lehicleStatus);
	}

	public void deleteById(Integer id) {
		lehicleStatusRepository.deleteById(id);
	}

}
