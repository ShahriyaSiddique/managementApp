package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Location;
import com.onik.ManagementApp.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> getLocations() {
		return (List<Location>) locationRepository.findAll();
	}

	public Optional<Location> findById(Integer id) {
		return locationRepository.findById(id);
	}

	public void save(Location location) {
		locationRepository.save(location);
	}

	public void deleteById(Integer id) {
		locationRepository.deleteById(id);
	}

}
