package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.EmployeeType;
import com.onik.ManagementApp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();
	}

	public Optional<EmployeeType> findById(Integer id) {
		return employeeTypeRepository.findById(id);
	}

	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	public void deleteById(Integer id) {
		employeeTypeRepository.deleteById(id);
	}

}
